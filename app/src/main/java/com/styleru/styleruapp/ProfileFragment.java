package com.styleru.styleruapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.styleru.styleruapp.Items.ProfileItem;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileFragment extends Fragment {
    private Unbinder mUnbinder;

    @BindView(R.id.profile_image_view)
    ImageView mProfileImageView;
    @BindView(R.id.first_name_text_view)
    TextView mFirstNameTextView;
    @BindView(R.id.second_name_text_view)
    TextView mSecondNameTextView;
    @BindView(R.id.directions_text_view)
    TextView mDirectionsTextView;
    @BindView(R.id.email_edit_text)
    EditText mEmailEditText;
    @BindView(R.id.phone_edit_text)
    EditText mPhoneEditText;
    @BindView(R.id.profile_constraint_layout)
    ConstraintLayout mLayout;


    public static Fragment newInstance(){
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mUnbinder = ButterKnife.bind(this, view);
        setData(view);
        return view;
    }

    private void setData(View view){
        HashMap<String, String> links = new HashMap<>();
        links.put("VK", "id4920");
        links.put("Instagram", "ngneecwmk.com");
        links.put("лицокнига", "navalnyi2018.com");

        ProfileItem sampleProfile = new ProfileItem("Vlad","Yundin",
                "Android",
                "null@gmail.com",
                "88005553535",
                "https://pp.userapi.com/c836234/v836234471/2fc01/CfB0TIHo8zE.jpg?ava=1",
                links);

        mFirstNameTextView.setText(sampleProfile.getFirstName());
        mSecondNameTextView.setText(sampleProfile.getSecondName());
        mDirectionsTextView.setText(sampleProfile.getDirections());
        mEmailEditText.setText(sampleProfile.getEmail());
        mPhoneEditText.setText(sampleProfile.getPhoneNumber());
        Glide.with(view)
                .load(sampleProfile.getPhoto())
                .into(mProfileImageView);

        getData();
        setLinks(links, view);
        }

    private void setLinks(HashMap<String, String> links, View view){
        String keys[] = new String[links.size()];
        keys = links.keySet().toArray(keys);
        for (int i = 0; i < links.size(); i++) {
            int linkTextViewID;
            int linkEditTextID;
            switch (i) {
                case 0:
                    linkTextViewID = R.id.textView0;
                    linkEditTextID = R.id.editText0;
                    break;
                case 1:
                    linkTextViewID = R.id.textView1;
                    linkEditTextID = R.id.editText1;
                    break;
                case 2:
                    linkTextViewID = R.id.textView2;
                    linkEditTextID = R.id.editText2;
                    break;
                case 3:
                    linkTextViewID = R.id.textView3;
                    linkEditTextID = R.id.editText3;
                    break;
                case 4:
                    linkTextViewID = R.id.textView4;
                    linkEditTextID = R.id.editText4;
                    break;
                default:
                    //just dog-nail to avoid red line
                    linkTextViewID = R.id.first_name_text_view;
                    linkEditTextID = R.id.email_edit_text;
                    break;
            }
            TextView linkNameTextView = view.findViewById(linkTextViewID);
            EditText linkURLEditText = view.findViewById(linkEditTextID);
            linkNameTextView.setText(keys[i]);
            linkNameTextView.setVisibility(View.VISIBLE);
            linkURLEditText.setText(links.get(keys[i]));
            linkURLEditText.setVisibility(View.VISIBLE);
        }
    }

    private void getData(){
        //there is no API to implement this method
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

}
