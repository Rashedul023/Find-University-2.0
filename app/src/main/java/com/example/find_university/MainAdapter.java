package com.example.find_university;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {

    DatabaseReference likereference;
    static FirebaseUser firebaseUser;

    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        String postKey = getRef(position).getKey();
        holder.getLikeButtonStatus(postKey);

        holder.like_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.likeButtonClicked(postKey);
            }
        });

        // Bind data to views
        holder.name.setText(model.getName());
        holder.country.setText("Country: " + model.getCountry());
        holder.cgpa.setText("Minimum CGPA: " + model.getCgpa());
        holder.area.setText("Total area: " + model.getArea() + " acres");
        holder.ielts.setText("IELTS score: " + model.getIelts());
        holder.student.setText("Total Student: " + model.getStudent());
        holder.fee.setText("Tuition fee per year: " + model.getFee() + " $");
        holder.rank.setText("Ranking: " + model.getRank());

        Glide.with(holder.img.getContext())
                .load(model.getUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.googleg_disabled_color_18)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView name, country, cgpa, area, ielts, student, fee, rank;
        ImageView like_btn;
        DatabaseReference likereference;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.nameText);
            country = itemView.findViewById(R.id.countryText);
            cgpa = itemView.findViewById(R.id.cgpaText);
            area = itemView.findViewById(R.id.areaText);
            ielts = itemView.findViewById(R.id.ieltsText);
            student = itemView.findViewById(R.id.studentText);
            fee = itemView.findViewById(R.id.feeText);
            rank = itemView.findViewById(R.id.rankText);
            like_btn = itemView.findViewById(R.id.like_btn);
        }

        public void getLikeButtonStatus(String postKey) {
            likereference = FirebaseDatabase.getInstance().getReference("likes").child(postKey);

            likereference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (firebaseUser != null) {
                        if (snapshot.hasChild(firebaseUser.getUid())) {
                            like_btn.setImageResource(R.drawable.baseline_favorite_24);
                        } else {
                            like_btn.setImageResource(R.drawable.baseline_favorite_border_24);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle errors
                }
            });
        }

        public void likeButtonClicked(String postKey) {
            if (firebaseUser != null) {
                likereference = FirebaseDatabase.getInstance().getReference("likes").child(postKey);

                likereference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(firebaseUser.getUid())) {
                            // User already liked, so remove the like
                            likereference.child(firebaseUser.getUid()).removeValue();
                            // Update "varsity" child to "n"
                            updateVarsityChild(postKey, "n");
                        } else {
                            // User has not liked, add the like
                            likereference.child(firebaseUser.getUid()).setValue(true);
                            // Update "varsity" child to "y"
                            updateVarsityChild(postKey, "y");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle errors
                    }
                });
            }
        }

        private void updateVarsityChild(String postKey, String value) {
            DatabaseReference varsityReference = FirebaseDatabase.getInstance().getReference().child("varsity").child(postKey).child(firebaseUser.getUid());
            varsityReference.setValue(value);
        }
    }
}
