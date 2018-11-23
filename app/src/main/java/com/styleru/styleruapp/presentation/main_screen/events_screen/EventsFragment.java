package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EventsFragment extends MvpAppCompatFragment implements EventsView{
    @BindView(R.id.pager) ViewPager mViewPager;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.tabLayout) TabLayout mTableLayout;
    @InjectPresenter EventsPresenter mPresenter;
    @Inject Provider<EventsPresenter> mProvidePresenter;
    @ProvidePresenter
    EventsPresenter providePresenter(){return mProvidePresenter.get();}

    Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_pager, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNavigationView.setSelectedItemId(R.id.events_menu);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            mPresenter.changeScreen(menuItem);
            return true;
        });
        mPresenter.provideData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    public void showData(List<EventItem> items){
        EventsPagerAdapter mPagerAdapter = new EventsPagerAdapter(getContext(),items);
        mViewPager.setAdapter(mPagerAdapter);
        mTableLayout.setupWithViewPager(mViewPager);
    }
    @Override
    public void onPeopleClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.PEOPLE_FRAGMENT);
    }

    @Override
    public void onProfileClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.PROFILE_FRAGMENT);

    }

    @Override
    public void onDirectionsClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.DIRECTIONS_FRAGMENT);

    }
}
/*

public class OldEventsFragment extends MvpAppCompatFragment implements EventsView {
    Unbinder mUnbinder;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.single_recycler_view) RecyclerView mRecyclerView;

    @InjectPresenter EventsPresenter mPresenter;
    @Inject Provider<EventsPresenter> mProvidePresenter;
    @ProvidePresenter EventsPresenter providePresenter(){return mProvidePresenter.get();}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container,false);
        mUnbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNavigationView.setSelectedItemId(R.id.events_menu);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            mPresenter.changeScreen(menuItem);
            return true;
        });
        mPresenter.provideData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    public void showData(List<EventItem> items){
        LayoutInflater inflater = getLayoutInflater();
        EventDataAdapter adapter = new EventDataAdapter(inflater, items);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onPeopleClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.PEOPLE_FRAGMENT);
    }

    @Override
    public void onProfileClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.PROFILE_FRAGMENT);

    }

    @Override
    public void onDirectionsClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.DIRECTIONS_FRAGMENT);

    }

}

 */