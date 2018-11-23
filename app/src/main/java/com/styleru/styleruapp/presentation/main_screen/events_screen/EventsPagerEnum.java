package com.styleru.styleruapp.presentation.main_screen.events_screen;


import com.styleru.styleruapp.R;

public enum EventsPagerEnum {
    ONLINE(R.string.online, R.layout.fragment_single_recycler_view),
    MEETING(R.string.meetings, R.layout.fragment_single_recycler_view),
    CONGREGATIONS(R.string.congregation, R.layout.fragment_single_recycler_view);

    private int mTitleResId;
    private int mLayoutResId;

    EventsPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }


}
