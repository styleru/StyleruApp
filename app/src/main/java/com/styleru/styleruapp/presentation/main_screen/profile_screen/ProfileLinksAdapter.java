package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.styleru.styleruapp.R;

import java.util.List;

public class ProfileLinksAdapter extends RecyclerView.Adapter<ProfileLinksAdapter.ProfileLinksHolder> {
    private LayoutInflater mInflater;
    private List<LinkItem> mItemList;
    ProfileLinksAdapter(LayoutInflater inflater, List<LinkItem> itemList) {
        mInflater = inflater;
        mItemList = itemList;
    }

    @NonNull
    @Override
    public ProfileLinksHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.link_item, viewGroup, false);
        return new ProfileLinksHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileLinksHolder profileLinksHolder, int i) {
        String site = mItemList.get(i).getSite() + ":";
        profileLinksHolder.mSiteTextView.setText(site);
        profileLinksHolder.mLinkTextView.setText(mItemList.get(i).getLink());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class ProfileLinksHolder extends RecyclerView.ViewHolder{
        private final TextView mSiteTextView;
        private final TextView mLinkTextView;
        ProfileLinksHolder(@NonNull View itemView) {
            super(itemView);
            mSiteTextView = itemView.findViewById(R.id.site_text_view);
            mLinkTextView = itemView.findViewById(R.id.link_text_view);
        }
    }
}
