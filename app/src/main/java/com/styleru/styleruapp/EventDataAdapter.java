package com.styleru.styleruapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.styleru.styleruapp.Items.EventItem;

import java.util.List;

public class EventDataAdapter extends RecyclerView.Adapter<EventDataAdapter.ViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<EventItem> mEventsItemList;

    public EventDataAdapter(LayoutInflater layoutInflater, List<EventItem> eventsItemList) {
        mLayoutInflater = layoutInflater;
        mEventsItemList = eventsItemList;
    }

    @NonNull
    @Override
    public EventDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.event_item, viewGroup, false);
        return new EventDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventDataAdapter.ViewHolder viewHolder, int i) {
        EventItem item = mEventsItemList.get(i);
        viewHolder.mInfoTextView.setText(item.getDate() + " " + item.getPlace());
        viewHolder.mTitleTextView.setText(item.getTitle());
        Glide.with(viewHolder.mEventImageView.getContext())
                .load(item.getImage())
                .into(viewHolder.mEventImageView);
    }
    @Override
    public int getItemCount() {
        return mEventsItemList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mEventImageView;
        final TextView mInfoTextView;
        final TextView mTitleTextView;
        ViewHolder(View view){
            super(view);
            mEventImageView = view.findViewById(R.id.item_event_image_view);
            mTitleTextView = view.findViewById(R.id.item_title_text_view);
            mInfoTextView = view.findViewById(R.id.item_info_text_vew);
        }
    }
}
