package com.styleru.styleruapp.presentation.main_screen.people_screen;

public class PeopleRecyclerModel {
    private String mFirstName;
    private String mSecondName;
    private String mDirections;
    private String mPhoto;
    private String mID;

    public PeopleRecyclerModel(String firstName, String secondName, String directions, String photo, String ID) {
        mFirstName = firstName;
        mSecondName = secondName;
        mDirections = directions;
        mPhoto = photo;
        mID = ID;
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

    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String photo) {
        mPhoto = photo;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }
}
