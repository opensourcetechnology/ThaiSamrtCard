package com.java.hosos.nhso.readfile;

public class DateFormat extends Date {

    private static final int ENG_YEAR = 543;

    public String thaiOfMonth() {
        String month = null;
        switch (getMonth()) {
            case 1:
                month = "มกราคม";
                break;
            case 2:
                month = "กุมภาพันธ์";
                break;
            case 3:
                month = "มีนาคม";
                break;
            case 4:
                month = "เมษายน";
                break;
            case 5:
                month = "พฤษภาคม";
                break;
            case 6:
                month = "มิถุนายน";
                break;
            case 7:
                month = "กรกฎาคม";
                break;
            case 8:
                month = "สิงหาคม";
                break;
            case 9:
                month = "กันยายน";
                break;
            case 10:
                month = "ตุลาคม";
                break;
            case 11:
                month = "พฤศจิกายน";
                break;
            case 12:
                month = "ธันวาคม";
                break;
        }
        return month;
    }

    public String engOfMonth() {
        String month = null;
        switch (getMonth()) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month;
    }

    public int thaiOfYear() {
        int th_year = 0;
        int eng_year = getYear();

        th_year = eng_year + ENG_YEAR;
        return th_year;
    }
}
