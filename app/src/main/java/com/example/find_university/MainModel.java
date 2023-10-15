package com.example.find_university;

public class MainModel {
    private String name;
    private String area;
    private String cgpa;
    private String country;
    private String fee;
    private String student;
    private String ielts;
    private String url;



    private String rank;

    private String csem;
    private String csed;

    private String ihd;
    private String ihm;

    private String ecm;
    private String ecd;

    private String mbm;
    private String mbd;

    private String phd;
    private String phm;

    private String arm;
    private String ard;

    private String fim;
    private String fid;

    private String agm;
    private String agd;

    private String ted;
    private String tem;

    private String med;
    private String mem;






    public MainModel() {
        // Default constructor required for Firebase
    }

    public MainModel(String name, Long area, Double cgpa, String country, Long fee, Long student, Double ielts, String url,Long rank,
                     String csem, String csed, String ihd, String ihm, String ecd, String ecm, String mbd, String mbm,
                     String phd, String phm, String ard, String arm, String fid, String fim, String agd, String agm,
                     String ted, String tem, String med, String mem) {
        this.name = name;
        this.area = String.valueOf(area);
        this.cgpa = String.valueOf(cgpa);
        this.country = country;
        this.fee = String.valueOf(fee);
        this.student = String.valueOf(student);
        this.ielts = String.valueOf(ielts);
        this.url = url;
        this.rank = String.valueOf(rank);
        this.csem = csem;
        this.csed =csed;
        this.ihd = ihd;
        this.ihm = ihm;
        this.ecd = ecd;
        this.ecm = ecm;

        this.mbd= mbd;
        this.mbm= mbm;

        this.phd= phd;
        this.phm = phm;
        this.ard= ard;
        this.arm= arm;
        this.fid = fid;
        this.fim= fim;
        this.agd = agd;
        this.agm = agm;
        this.ted = ted;
        this.tem = tem;
        this.med = med;
        this.mem = mem;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return Long.parseLong(area);
    }

    public void setArea(Long area) {
        this.area = String.valueOf(area);
    }

    public Double getCgpa() {
        return Double.parseDouble(cgpa);
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = String.valueOf(cgpa);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getFee() {
        return Long.parseLong(fee);
    }

    public void setFee(Long fee) {
        this.fee = String.valueOf(fee);
    }

    public Long getStudent() {
        return Long.parseLong(student);
    }

    public void setStudent(Long student) {
        this.student = String.valueOf(student);
    }

    public Double getIelts() {
        return Double.parseDouble(ielts);
    }

    public void setIelts(Double ielts) {
        this.ielts = String.valueOf(ielts);
    }

    public Long getRank(){
        return Long.parseLong(rank);
    }
    public void setRank(Long rank){
        this.rank = String.valueOf(rank);
    }

    public String getUrl() {
        return url;
    }
    public String getCsem() {
        return csem;
    }

    public void setCsem(String csem) {
        this.csem = csem;
    }

    public String getCsed() {
        return csed;
    }

    public void setCsed(String csed) {
        this.csed = csed;
    }


    public String getIhd() {
        return ihd;
    }

    public void setIhd(String ihd) {
        this.ihd = ihd;
    }

    public String getIhm() {
        return ihm;
    }

    public void setIhm(String ihm) {
        this.ihm = ihm;
    }

    public String getEcm() {
        return ecm;
    }

    public void setEcm(String ecm) {
        this.ecm = ecm;
    }

    public String getEcd() {
        return ecd;
    }

    public void setEcd(String ecd) {
        this.ecd = ecd;
    }

    public String getMbm() {
        return mbm;
    }

    public void setMbm(String mbm) {
        this.mbm = mbm;
    }

    public String getMbd() {
        return mbd;
    }

    public void setMbd(String mbd) {
        this.mbd = mbd;
    }

    public String getPhd() {
        return phd;
    }

    public void setPhd(String phd) {
        this.phd = phd;
    }

    public String getPhm() {
        return phm;
    }

    public void setPhm(String phm) {
        this.phm = phm;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }

    public String getArd() {
        return ard;
    }

    public void setArd(String ard) {
        this.ard = ard;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getAgm() {
        return agm;
    }

    public void setAgm(String agm) {
        this.agm = agm;
    }

    public String getAgd() {
        return agd;
    }

    public void setAgd(String agd) {
        this.agd = agd;
    }

    public String getTed() {
        return ted;
    }

    public void setTed(String ted) {
        this.ted = ted;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
