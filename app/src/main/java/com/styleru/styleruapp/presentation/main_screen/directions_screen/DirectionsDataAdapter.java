package com.styleru.styleruapp.presentation.main_screen.directions_screen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.styleru.styleruapp.R;

import java.util.List;

public class DirectionsDataAdapter extends RecyclerView.Adapter<DirectionsDataAdapter.DirectionsDataHolder> {
    private LayoutInflater mInflater;
    private List<DirectionsItem> mItemList;
    DirectionsDataAdapter(LayoutInflater inflater, List<DirectionsItem> items) {
        mInflater = inflater;
        mItemList = items;
    }

    @NonNull
    @Override
    public DirectionsDataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.directions_item, viewGroup, false);
        return new DirectionsDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectionsDataHolder directionsDataHolder, int i) {
        DirectionsItem item = mItemList.get(i);
        directionsDataHolder.mTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class DirectionsDataHolder extends RecyclerView.ViewHolder{
        private final TextView mTitle;
        DirectionsDataHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.directions_item_title);
        }
    }
}
