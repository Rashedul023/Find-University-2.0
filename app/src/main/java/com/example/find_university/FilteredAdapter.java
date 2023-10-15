package com.example.find_university;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

import java.util.List;

public class FilteredAdapter extends RecyclerView.Adapter<FilteredAdapter.ViewHolder> {


    private List<MainModel> filteredList;

    public FilteredAdapter(List<MainModel> filteredList) {
        this.filteredList = filteredList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filtered_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainModel item = filteredList.get(position);

        holder.name.setText(item.getName());
        holder.country.setText("Country: " + item.getCountry());
        holder.cgpa.setText("Minimum CGPA: " + item.getCgpa());
        holder.area.setText("Total area: " + item.getArea() + " acres");
        holder.ielts.setText("IELTS score: " + item.getIelts());
        holder.student.setText("Total Student: " + item.getStudent());
        holder.fee.setText("Tuition fee per year: " + item.getFee() + " $");
        holder.rank.setText("Ranking: " + item.getRank());

        Glide.with(holder.img.getContext())
                .load(item.getUrl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_text_disabled)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView name, country, cgpa, area, ielts, student, fee, rank;
        public ViewHolder(@NonNull View itemView) {
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
        }

    }
}
