package com.example.find_university;

public class User {

    private String uname;
    private String uid;
    private String major;
    private String cgpa;
    private String ielts;

    public User() {

    }

    public User(String uname, String major, String uid, String cgpa, String ielts) {
        this.uname = uname;
        this.major = major;
        this.uid = uid;
        this.cgpa = cgpa;
        this.ielts = ielts;
    }

    public User(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getIelts() {
        return ielts;
    }

    public void setIelts(String ielts) {
        this.ielts = ielts;
    }
}
