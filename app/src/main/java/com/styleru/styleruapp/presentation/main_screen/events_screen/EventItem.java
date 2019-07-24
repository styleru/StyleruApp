package com.styleru.styleruapp.presentation.main_screen.events_screen;

public class EventItem {
    private String mImage;
    private String mTitle;
    private String mDate;
    private String mPlace;
    private String mDescription;

    public EventItem(String image, String title, String date, String place, String description) {
        mImage = image;
        mTitle = title;
        mDate = date;
        mPlace = place;
        mDescription = description;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
