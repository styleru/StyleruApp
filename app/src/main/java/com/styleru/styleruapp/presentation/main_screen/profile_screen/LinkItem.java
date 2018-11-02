package com.styleru.styleruapp.presentation.main_screen.profile_screen;

public class LinkItem {
    private String mSite;
    private String mLink;

    LinkItem(String site, String link) {
        mSite = site;
        mLink = link;
    }

    String getSite() {
        return mSite;
    }

    public void setSite(String site) {
        mSite = site;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }
}
