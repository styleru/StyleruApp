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

    EventsPagerAdapter(Context context, List<EventItem> eventItems) {
        mContext = context;
        mEventItems = eventItems;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        EventsPagerEnum pagerEnum = EventsPagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(pagerEnum.getLayoutResId(), container, false);

        RecyclerView recyclerView = layout.findViewById(R.id.pager_recycler_view);
        EventDataAdapter adapter = new EventDataAdapter(inflater, mEventItems);
        recyclerView.setAdapter(adapter);
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
}
