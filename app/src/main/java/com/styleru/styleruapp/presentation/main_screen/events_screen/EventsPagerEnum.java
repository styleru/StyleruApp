package com.styleru.styleruapp.presentation.main_screen.events_screen;


import com.styleru.styleruapp.R;

public enum EventsPagerEnum {
    ONLINE(R.string.online, R.layout.pager_events_online),
    MEETINGS(R.string.meetings, R.layout.pager_events_meetings),
    CONGREGATIONS(R.string.congregation, R.layout.pager_events_congregations);

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
