package com.tab.model;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
public class UserMocha {

    private String userName;
    private String photoURL;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "UserMocha{" +
                "userName='" + userName + '\'' +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
