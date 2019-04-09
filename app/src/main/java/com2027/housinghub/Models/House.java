package com2027.housinghub.Models;
/**
 *
 */

import android.location.Location;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 *
 */
public class House implements Parcelable {
    //Figure out how to implement id
    private String houseId;
    private String houseTitle;
    private String houseDescription;
    private List<String> tags;
    private LandlordAccount landlordAccount;
    private Location location;
    private double price;
    private TimeFrame availableFor;
    private List<Image> images;
    private boolean isOccupied;

    public House(){

    }

    /**
     *
     * @param houseTitle
     * @param houseDescription
     * @param tags
     * @param landlordAccount
     * @param price
     * @param location
     * @param timeFrame
     * @param images
     */
    public House(String houseTitle, String houseDescription, List<String> tags, LandlordAccount landlordAccount, double price, Location location, TimeFrame timeFrame, List<Image> images){
        this.houseTitle = houseTitle;
        this.houseDescription = houseDescription;
        this.tags = tags;
        this.landlordAccount = landlordAccount;
        this.price = price;
        this.location = location;
        this.availableFor = timeFrame;
        this.images = images;
        this.isOccupied = false;

        //houseId
    }

    protected House(Parcel in) {
        houseId = in.readString();
        houseTitle = in.readString();
        houseDescription = in.readString();
        tags = in.createStringArrayList();
        landlordAccount = in.readParcelable(LandlordAccount.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        price = in.readDouble();
        isOccupied = in.readByte() != 0;
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };

    /**
     *
     *
     */


    public TimeFrame getAvailableFor() {
        return availableFor;
    }

    public void setAvailableFor(TimeFrame availableFor) {
        this.availableFor = availableFor;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public LandlordAccount getLandlordAccount() {
        return landlordAccount;
    }

    public void setLandlordAccount(LandlordAccount landlordAccount) {
        this.landlordAccount = landlordAccount;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(houseId);
        parcel.writeString(houseTitle);
        parcel.writeString(houseDescription);
        parcel.writeStringList(tags);
        parcel.writeParcelable(landlordAccount, i);
        parcel.writeParcelable(location, i);
        parcel.writeDouble(price);
        parcel.writeByte((byte) (isOccupied ? 1 : 0));
    }
}
