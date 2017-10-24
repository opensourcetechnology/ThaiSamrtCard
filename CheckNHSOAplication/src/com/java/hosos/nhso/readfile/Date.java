
package com.java.hosos.nhso.readfile;

public class Date {
    private static String date;
    private static String time;

    private static int day;
    private static int month;
    private static int year;
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        Date.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        Date.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Date.year = year;
    }
}
