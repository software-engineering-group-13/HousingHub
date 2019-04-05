package com2027.housinghub.Models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class UserAccount implements Parcelable {

    private String firstName;
    private String lastName;
    private int age;

    private Date dateOfBirth;
    private String birthday;


    private Location location;
    private double latitude;
    private double longitude;


    /**
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param dateOfBirth
     * @param location
     */
    public UserAccount(String firstName, String lastName, int age, Date dateOfBirth, Location location){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age =age;
        this.dateOfBirth = dateOfBirth;
        this.location = location;

        birthday = dateOfBirth.toString();
        longitude = location.getLongitude();
        latitude = location.getLatitude();
    }

    /**
     *
     */
    public UserAccount(){

    }




    protected UserAccount(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        age= in.readInt();
        birthday = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();

    }

    public static final Creator<UserAccount> CREATOR = new Creator<UserAccount>() {
        @Override
        public UserAccount createFromParcel(Parcel in) {
            return new UserAccount(in);
        }

        @Override
        public UserAccount[] newArray(int size) {
            return new UserAccount[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(firstName);
        destination.writeString(lastName);
        destination.writeInt(age);
        destination.writeDouble(longitude);
        destination.writeDouble(latitude);
    }
}
