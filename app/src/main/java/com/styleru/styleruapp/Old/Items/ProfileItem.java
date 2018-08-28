package com.styleru.styleruapp.Old.Items;

import java.util.HashMap;

public class ProfileItem {
    private String mFirstName;
    private String mSecondName;
    private String mDirections;
    private String mEmail;
    private String mPhoneNumber;
    private String mPhoto;
    private HashMap<String, String > mLinks;

    public ProfileItem(String firstName, String secondName, String directions, String email, String phoneNumber, String photo, HashMap<String, String> links) {
        mFirstName = firstName;
        mSecondName = secondName;
        mDirections = directions;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mPhoto = photo;
        mLinks = links;
    }

    public ProfileItem(String firstName, String directions, String photo) {
        mFirstName = firstName;
        mDirections = directions;
        mPhoto = photo;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getSecondName() {
        return mSecondName;
    }

    public void setSecondName(String secondName) {
        mSecondName = secondName;
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

    public void setLinks(HashMap<String, String> links) {
        mLinks = links;
    }
}

