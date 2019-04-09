package com2027.housinghub.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 */
public class User implements Parcelable {

    private String user_id;
    private String email;
    private String username;
    private String password;
    private UserType type;



    /**
     *
     * @param username
     * @param email
     * @param password
     */
    public User( String username, String email, String password, UserType type ){
        this.email = email;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * Default Constructor
     */
    public User(){

    }

    /**
     *
     * @param in
     */
    protected User(Parcel in) {
        user_id = in.readString();
        email = in.readString();
        username = in.readString();
        password = in.readString();
    }

    /**
     *
     */
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(user_id);
        parcel.writeString(email);
        parcel.writeString(username);
        parcel.writeString(password);
    }
}
