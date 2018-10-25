package com.styleru.styleruapp.presentation.main_screen.people_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.presentation.main_screen.ProfileItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PeopleFragment extends MvpAppCompatFragment implements PeopleView {
    Unbinder mUnbinder;
    @InjectPresenter PeoplePresenter mPresenter;
    @Inject Provider<PeoplePresenter> mProvider;
    @ProvidePresenter PeoplePresenter getPresenter(){return mProvider.get();}
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.single_recycler_view) RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            mPresenter.changeScreen(menuItem);
            return true;
        });
        //mUnbinder = ButterKnife.bind(this, view);
        ProfileItem sampleProfile = new ProfileItem("dolphin", "web", "https://pp.userapi.com/c847123/v847123031/156d/kxJRy2z3nOA.jpg");
        List<ProfileItem> mProfiles = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            mProfiles.add(sampleProfile);
        }
        PeopleDataAdapter adapter = new PeopleDataAdapter(inflater, mProfiles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
