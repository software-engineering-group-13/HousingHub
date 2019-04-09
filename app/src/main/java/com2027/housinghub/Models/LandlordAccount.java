package com2027.housinghub.Models;

import android.location.Location;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class LandlordAccount extends UserAccount implements Parcelable {
    private List<House> houses;
    //private rentedHouses
    private String contactMobile;
    private String contactEmail;
    private Preference preference;
    private boolean isVerified;
    private Status verifiedStatus;
    private double rating;
    private List<Review> reviews;

    /**
     *
     */
    public LandlordAccount(){

    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param dateOfBirth
     * @param location
     * @param houses
     * @param contactMobile
     * @param contactEmail
     * @param preference
     * @param isVerified
     * @param verifiedStatus
     * @param rating
     * @param reviews
     */
    public LandlordAccount(String firstName, String lastName, int age, Date dateOfBirth, Location location,List<House> houses, String contactMobile, String contactEmail, Preference preference, boolean isVerified,
                           Status verifiedStatus, double rating, List<Review> reviews){

        super(firstName, lastName,age,dateOfBirth,location);
        this.houses = houses;
        this.contactEmail = contactEmail;
        this.contactMobile = contactMobile;
        this.preference = preference;
        this.isVerified = isVerified;
        this.verifiedStatus = verifiedStatus;
        this.rating = rating;
        this.reviews = reviews;

    }



}
