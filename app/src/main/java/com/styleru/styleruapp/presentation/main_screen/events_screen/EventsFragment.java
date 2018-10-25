package com.styleru.styleruapp.presentation.main_screen.events_screen;

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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EventsFragment extends MvpAppCompatFragment implements EventsView {
    Unbinder mUnbinder;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.single_recycler_view) RecyclerView mRecyclerView;

    @InjectPresenter EventsPresenter mPresenter;
    @Inject Provider<EventsPresenter> mProvidePresenter;
    @ProvidePresenter EventsPresenter providePresenter(){return mProvidePresenter.get();}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container,false);
        mUnbinder = ButterKnife.bind(this,view);
        mBottomNavigationView.setSelectedItemId(R.id.events_menu);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            mPresenter.changeScreen(menuItem);
            return true;
        });
        EventItem sampleProfile = new EventItem("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Bufotes_oblongus.jpg/275px-Bufotes_oblongus.jpg", "java meetup", "31.12.2018", "red square");
        List<EventItem> mProfiles = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            mProfiles.add(sampleProfile);
        }
        EventDataAdapter adapter = new EventDataAdapter(inflater, mProfiles);
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
