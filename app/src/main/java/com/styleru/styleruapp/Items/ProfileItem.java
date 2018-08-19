package com.styleru.styleruapp.Items;

import java.util.HashMap;

public class ProfileItem {
    private String mName;
    private String mDirections;
    private String mEmail;
    private String mPhoneNumber;
    private String mPhoto;
    private HashMap<String, String > mLinks;

    public ProfileItem(String name, String directions, String email, String phoneNumber, String photo, HashMap<String, String> links) {
        mName = name;
        mDirections = directions;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mPhoto = photo;
        mLinks = links;
    }

    public ProfileItem(String name, String directions, String photo) {
        mName = name;
        mDirections = directions;
        mPhoto = photo;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDirections() {
        return mDirections;
    }

    public void setDirections(String directions) {
        mDirections = directions;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String photo) {
        mPhoto = photo;
    }

    public HashMap<String, String> getLinks() {
        return mLinks;
    }

    public void HashMap(HashMap<String, String> links) {
        mLinks = links;
    }
}

