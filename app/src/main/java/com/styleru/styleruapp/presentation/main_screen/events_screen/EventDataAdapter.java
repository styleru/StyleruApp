package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.styleru.styleruapp.R;

import java.util.List;

public class EventDataAdapter extends RecyclerView.Adapter<EventDataAdapter.ViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<EventItem> mEventsItemList;
    private View.OnClickListener mOnClickListener;

    EventDataAdapter(LayoutInflater layoutInflater, List<EventItem> eventsItemList, View.OnClickListener onClickListener) {
        mLayoutInflater = layoutInflater;
        mEventsItemList = eventsItemList;
        mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public EventDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.event_item, viewGroup, false);
        view.setOnClickListener(mOnClickListener);
        return new EventDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventDataAdapter.ViewHolder viewHolder, int i) {
        EventItem item = mEventsItemList.get(i);
        viewHolder.mPlaceTextView.setText(item.getPlace());
        viewHolder.mTitleTextView.setText(item.getTitle());
        viewHolder.mDateTextView.setText(item.getDate());
        Glide.with(viewHolder.mEventImageView.getContext())
                .load(item.getImage())
                .into(viewHolder.mEventImageView);
    }
    @Override
    public int getItemCount() {
        return mEventsItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mEventImageView;
        final TextView mPlaceTextView;
        final TextView mDateTextView;
        final TextView mTitleTextView;
        ViewHolder(View view){
            super(view);
            mEventImageView = view.findViewById(R.id.item_event_image_view);
            mTitleTextView = view.findViewById(R.id.item_title_text_view);
            mPlaceTextView = view.findViewById(R.id.place_info_text_vew);
            mDateTextView = view.findViewById(R.id.event_date_text_view);
        }
    }
}
