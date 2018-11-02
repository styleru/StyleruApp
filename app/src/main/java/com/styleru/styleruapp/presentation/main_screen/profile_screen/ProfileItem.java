package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import java.util.List;

public class ProfileItem {
    private String mFirstName;
    private String mSecondName;
    private String mDirections;
    private String mEmail;
    private String mPhoneNumber;
    private String mPhoto;
    private List<LinkItem> mLinks;

    public ProfileItem(String firstName, String secondName, String directions, String email, String phoneNumber, String photo, List<LinkItem> links) {
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

    String getSecondName() {
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

    String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String photo) {
        mPhoto = photo;
    }

    public List<LinkItem> getLinks() {
        return mLinks;
    }

    public void setLinks(List<LinkItem> links) {
        mLinks = links;
    }
}

