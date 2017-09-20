
package com.java.client;

public class DataServices {
    
    static String house;
    static String moo;
    static String soi;
    static String road;
    static String tambon;
    static String amphur;
    static String changwat;
    static String yyyy;
    static String mm;
    static String dd;
    static String gender;
    
    public DataServices(){}

// getter
    public String getHouse() {
        return house;
    }

    public String getMoo() {
        return moo;
    }

    public String getSoi() {
        return soi;
    }

    public String getRoad() {
        return road;
    }

    public String getTambon() {
        return tambon;
    }

    public String getAmphur() {
        return amphur;
    }

    public String getChangwat() {
        return changwat;
    }

    public String getYyyy() {
        return yyyy;
    }

    public String getMm() {
        return mm;
    }

    public String getDd() {
        return dd;
    }

    public String getGender() {
        return gender;
    }

// Setter
    public void setHouse(String house) {
        this.house = house;
    }

    public void setMoo(String moo) {
        this.moo = moo;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setTambon(String tambon) {
        this.tambon = tambon;
    }

    public void setAmphur(String amphur) {
        this.amphur = amphur;
    }

    public void setChangwat(String changwat) {
        this.changwat = changwat;
    }

    public void setYyyy(String yyyy) {
        DataServices.yyyy = yyyy;
    }

    public void setMm(String mm) {
        DataServices.mm = mm;
    }

    public void setDd(String dd) {
        DataServices.dd = dd;
    }

    public void setGender(String gender) {
        DataServices.gender = gender;
    }
    
    public String getFormatBOD(){
        return yyyy+"-"+mm+"-"+dd;
    }
    
}
