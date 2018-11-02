package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileFragment extends MvpAppCompatFragment implements ProfileView {
    private Unbinder mUnbinder;
    private View mView;
    private LayoutInflater mInflater;
    @InjectPresenter ProfilePresenter mPresenter;
    @Inject Provider<ProfilePresenter> mProvider;
    @ProvidePresenter ProfilePresenter getPresenter() {return mProvider.get();}

    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.profile_links_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.profile_image_view) ImageView mProfileImageView;
    @BindView(R.id.first_name_text_view) TextView mFirstNameTextView;
    @BindView(R.id.second_name_text_view) TextView mSecondNameTextView;
    @BindView(R.id.directions_text_view) TextView mDirectionsTextView;
    @BindView(R.id.email_edit_text)  EditText mEmailEditText;
    @BindView(R.id.phone_edit_text) EditText mPhoneEditText;
    @BindView(R.id.profile_constraint_layout) ConstraintLayout mLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        mUnbinder = ButterKnife.bind(this, mView);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNavigationView.setSelectedItemId(R.id.profile_menu);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            mPresenter.changeScreen(menuItem);
            return true;
        });
        mInflater = getLayoutInflater();
        mPresenter.provideData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void showData(ProfileItem profileItem, List<LinkItem> links) {
        mFirstNameTextView.setText(profileItem.getFirstName());
        mSecondNameTextView.setText(profileItem.getSecondName());
        mDirectionsTextView.setText(profileItem.getDirections());
        mEmailEditText.setText(profileItem.getEmail());
        mPhoneEditText.setText(profileItem.getPhoneNumber());
        Glide.with(mView)
                .load(profileItem.getPhoto())
                .into(mProfileImageView);
        mRecyclerView.setAdapter(new ProfileLinksAdapter(mInflater, links));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
