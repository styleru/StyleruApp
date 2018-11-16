package com.styleru.styleruapp.presentation.main_screen.profile_screen.edit_profile;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.styleru.styleruapp.R;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.LinkItem;

import java.util.List;

public class EditProfileAdapter extends RecyclerView.Adapter<EditProfileAdapter.EditProfileViewHolder> {
    private LayoutInflater mInflater;
    private List<LinkItem> mItemList;

    public EditProfileAdapter(LayoutInflater inflater, List<LinkItem> itemList) {
        mInflater = inflater;
        mItemList = itemList;
    }

    @NonNull
    @Override
    public EditProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.link_edit_item, viewGroup, false);
        return new EditProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditProfileViewHolder holder, int i) {
        String site = mItemList.get(i).getSite() + ":";
        holder.mSiteTextView.setText(site);
        holder.mLinkTextView.setText(mItemList.get(i).getLink());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class EditProfileViewHolder extends RecyclerView.ViewHolder{
        private final EditText mSiteTextView;
        private final EditText mLinkTextView;
        EditProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            mSiteTextView = itemView.findViewById(R.id.site_edit_text);
            mLinkTextView = itemView.findViewById(R.id.link_edit_text);
        }
    }
}
