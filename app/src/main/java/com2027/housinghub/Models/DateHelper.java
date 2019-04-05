package com2027.housinghub.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 */
public class DateHelper implements Parcelable {

    private int day;
    private int month;
    private int year;

    private int monthString;

    /**
     *
     * @param day
     * @param month
     * @param year
     */
    public DateHelper(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }


    protected DateHelper(Parcel in) {
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
    }

    public static final Creator<DateHelper> CREATOR = new Creator<DateHelper>() {
        @Override
        public DateHelper createFromParcel(Parcel in) {
            return new DateHelper(in);
        }

        @Override
        public DateHelper[] newArray(int size) {
            return new DateHelper[size];
        }
    };

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonthString(){
        String sMonth = "";
        switch (month){
            case 1:
                sMonth = "Janurary";
                break;

            case 2:
                sMonth = "February";
                break;
            case 3:
                sMonth = "March";
                break;

            case 4:
                sMonth = "April";
            break;

            case 5:
                sMonth = "May";
            break;

            case 6:
                sMonth = "June";
            break;

            case 7:
                sMonth = "July";
            break;

            case 8:
                sMonth = "August";
            break;

            case 9:
                sMonth = "September";
            break;

            case 10:
                sMonth = "October";
            break;

            case 11:
                sMonth = "November";
            break;
            case 12:
                sMonth = "December";
            break;

        }
        return sMonth;
    }

    @Override
    public String toString(){
        return day +" " +getMonthString() +" " +getYear();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(day);
        parcel.writeInt(month);
        parcel.writeInt(year);
    }
}
