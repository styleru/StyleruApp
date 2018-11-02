package com.styleru.styleruapp.presentation.main_screen.people_screen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileItem;

import java.util.List;

public class PeopleDataAdapter extends RecyclerView.Adapter<PeopleDataAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<ProfileItem> mProfileItemList;

    PeopleDataAdapter(LayoutInflater layoutInflater, List<ProfileItem> profileItemList) {
        mLayoutInflater = layoutInflater;
        mProfileItemList = profileItemList;
    }

    @NonNull
    @Override
    public PeopleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.people_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ProfileItem item = mProfileItemList.get(i);
        viewHolder.mDirectionsTextView.setText(item.getDirections());
        viewHolder.mNameTextView.setText(item.getFirstName());
        Glide.with(viewHolder.mPersonImageView.getContext())
                .load("https://pp.userapi.com/c847123/v847123031/156d/kxJRy2z3nOA.jpg")
                .into(viewHolder.mPersonImageView);
    }
    @Override
    public int getItemCount() {
        return mProfileItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView mPersonImageView;
    final TextView mDirectionsTextView;
    final TextView mNameTextView;
        ViewHolder(View view){
            super(view);
            mPersonImageView = view.findViewById(R.id.item_person_image_view);
            mNameTextView = view.findViewById(R.id.item_name_text_view);
            mDirectionsTextView = view.findViewById(R.id.item_directions_text_vew);
        }
    }
}
