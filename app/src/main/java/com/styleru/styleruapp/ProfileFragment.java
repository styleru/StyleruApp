package com.styleru.styleruapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.styleru.styleruapp.Items.ProfileItem;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileFragment extends Fragment {
    private Unbinder mUnbinder;

    @BindView(R.id.profile_image_view)
    ImageView mProfileImageView;
    @BindView(R.id.name_text_view)
    TextView mNameTextView;
    @BindView(R.id.directions_text_view)
    TextView mDirectionsTextView;
    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;
    @BindView(R.id.phone_edit_text)
    EditText mPhoneEditText;

    public static Fragment newInstance(){
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mUnbinder = ButterKnife.bind(this, view);
        getFakeData(view);
        return view;
    }

    private void getFakeData(View view){
        ProfileItem sampleProfile = new ProfileItem("Vlad Yundin",
                "Android",
                "null@gmail.com",
                "88005553535",
                "https://pp.userapi.com/c836234/v836234471/2fc01/CfB0TIHo8zE.jpg?ava=1");

        mNameTextView.setText(sampleProfile.getName());
        mDirectionsTextView.setText(sampleProfile.getDirections());
        mEmailEditText.setText(sampleProfile.getEmail());
        mPhoneEditText.setText(sampleProfile.getPhoneNumber());
        Glide.with(view)
                .load(sampleProfile.getPhoto())
                .into(mProfileImageView);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
