package com.styleru.styleruapp.presentation.main_screen.profile_screen;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruNavigator;
import com.styleru.styleruapp.navigation.StyleruRouter;

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
    private boolean mIsEditable;
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
    @BindView(R.id.profile_main_layout) RelativeLayout mLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        mUnbinder = ButterKnife.bind(this, mView);


        return mView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (mIsEditable)
        {
            inflater.inflate(R.menu.menu_profile, menu);
            MenuItem item = menu.getItem(0);
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }
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


        Toolbar toolbar = view.findViewById(R.id.toolbar);
        getActivity().setActionBar(toolbar);
        ActionBar actionBar = getActivity().getActionBar();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void showData(ProfileModel profileItem) {
        Bundle bundle = getArguments();
        mIsEditable = !(bundle!= null && bundle.containsKey(StyleruNavigator.ID) && bundle.getString(StyleruNavigator.ID) != null);
        List<LinkItem> links = profileItem.getLinks();
        mFirstNameTextView.setText(profileItem.getFirstName());
        mSecondNameTextView.setText(profileItem.getSecondName());
        mDirectionsTextView.setText(profileItem.getDirections());
        mEmailEditText.setText(profileItem.getEmail());
        mPhoneEditText.setText(profileItem.getPhoneNumber());
        Glide.with(mView)
                .load(profileItem.getPhoto())
                .into(mProfileImageView);
        mRecyclerView.setAdapter(new ProfileLinksAdapter(mInflater, links, mIsEditable));

    }

    @Override
    public void onPeopleClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.PEOPLE_FRAGMENT);
    }

    @Override
    public void onEventsClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.EVENTS_FRAGMENT);
    }

    @Override
    public void onDirectionsClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.DIRECTIONS_FRAGMENT);
    }
}
