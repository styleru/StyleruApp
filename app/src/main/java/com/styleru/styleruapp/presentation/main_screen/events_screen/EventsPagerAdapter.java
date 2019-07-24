package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.styleru.styleruapp.R;

import java.util.List;

public class EventsPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<EventItem> mEventItems;
    private RecyclerView mOnlineRecyclerView;
    private RecyclerView mMeetingsRecyclerView;
    private RecyclerView mCongregationsRecyclerView;
    private View.OnClickListener mOnClickListener;
    EventsPagerAdapter(Context context, List<EventItem> eventItems, View.OnClickListener onClickListener) {
        mContext = context;
        mEventItems = eventItems;
        mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        EventsPagerEnum pagerEnum = EventsPagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(pagerEnum.getLayoutResId(), container, false);

        EventDataAdapter adapter = new EventDataAdapter(inflater, mEventItems, mOnClickListener);
        switch (position){
            case 0:
                mOnlineRecyclerView = layout.findViewById(R.id.online_recycler_view);
                mOnlineRecyclerView.setAdapter(adapter);
                break;
            case 1:
                mMeetingsRecyclerView = layout.findViewById(R.id.meetings_recycler_view);
                mMeetingsRecyclerView.setAdapter(adapter);
                break;
            case 2:
                mCongregationsRecyclerView = layout.findViewById(R.id.congregations_recycler_view);
                mCongregationsRecyclerView.setAdapter(adapter);
                break;
        }
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View)view);
    }

    @Override
    public int getCount() {
        return EventsPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        EventsPagerEnum pagerEnum = EventsPagerEnum.values()[position];
        return mContext.getString(pagerEnum.getTitleResId());
    }

    void scrollToTop(int position){
        switch (position){
            case 0:
                mOnlineRecyclerView.smoothScrollToPosition(0);
                break;
            case 1:
                mMeetingsRecyclerView.smoothScrollToPosition(0);
                break;
            case 2:
                mCongregationsRecyclerView.smoothScrollToPosition(0);
                break;
        }
    }

}
