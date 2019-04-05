package com2027.housinghub.Models;

/**
 *
 */

public class UserSettings {
    private User user;
    private UserAccount settings;

    /**
     *
     * @param user
     * @param settings
     */
    public UserSettings(User user, UserAccount settings){

        this.user = user;
        this.settings = settings;

    }

    public UserSettings(){

    }

    public UserAccount getSettings() {
        return settings;
    }

    public void setSettings(UserAccount settings) {
        this.settings = settings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "user=" + user +
                ", settings=" + settings +
                '}';
    }
}
