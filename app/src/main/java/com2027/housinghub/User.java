package com2027.housinghub;

public class User {
    public String firstName, surname, email, phone, userType;

    public User() {

    }

    public User(String firstName, String surname, String email, String userType) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.userType = userType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
