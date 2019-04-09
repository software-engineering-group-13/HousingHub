package com2027.housinghub.Models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class StudentAccount extends UserAccount implements Parcelable {

    private String biography;
    private List<House> favouriteHouses;
    private List<House> savedHouses;
    Preference preference;
    private GroupHelper group;
    private YearHelper year;
    private String university;

    public StudentAccount(){

    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param dateOfBirth
     * @param location
     * @param biography
     * @param favouriteHouses
     * @param savedHouses
     * @param preference
     * @param group
     * @param year
     * @param university
     */
    public StudentAccount(String firstName, String lastName, int age, Date dateOfBirth, Location location,String biography, List<House> favouriteHouses, List<House> savedHouses, Preference preference,
                          GroupHelper group, YearHelper year, String university){
        super(firstName, lastName, age, dateOfBirth, location);

        this.biography = biography;
        this.favouriteHouses = favouriteHouses;
        this.savedHouses = savedHouses;
        this.group = group;
        this.preference =preference;
        this.year = year;
        this.university = university;
    }

    protected StudentAccount(Parcel in){
        biography = in.readString();
        //favouriteHouses
        //savedHouses
        group = in.readParcelable(GroupHelper.class.getClassLoader());
        preference = in.readParcelable(Preference.class.getClassLoader());
        year = in.readParcelable(YearHelper.class.getClassLoader());
        university = in.readString();

    }

    public static final Creator<StudentAccount> CREATOR = new Creator<StudentAccount>() {
        @Override
        public StudentAccount createFromParcel(Parcel parcel) {
            return new StudentAccount(parcel);
        }

        @Override
        public StudentAccount[] newArray(int i) {
            return new StudentAccount[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(biography);
        //check what really really does
        dest.writeParcelable((Parcelable) group, flags);
        dest.writeParcelable((Parcelable) preference, flags);
        //dest.writeParcelableArray(, flags);
        //for houses, not sure if its important. at least for now.
        dest.writeString(year.toString());
        dest.writeString(university);

    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<House> getFavouriteHouses() {
        return favouriteHouses;
    }

    public void setFavouriteHouses(List<House> favouriteHouses) {
        this.favouriteHouses = favouriteHouses;
    }

    public GroupHelper getGroup() {
        return group;
    }

    public void setGroup(GroupHelper group) {
        this.group = group;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public List<House> getSavedHouses() {
        return savedHouses;
    }

    public void setSavedHouses(List<House> savedHouses) {
        this.savedHouses = savedHouses;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public YearHelper getYear() {
        return year;
    }

    public void setYear(YearHelper year) {
        this.year = year;
    }
}
