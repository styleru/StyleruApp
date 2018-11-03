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
import com.styleru.styleruapp.navigation.ScreenKeys;
import com.styleru.styleruapp.navigation.StyleruRouter;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileItem;

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
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNavigationView.setSelectedItemId(R.id.people_menu);
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

    @Override
    public void showData(List<ProfileItem> items) {
        LayoutInflater inflater = getLayoutInflater();
        PeopleDataAdapter adapter = new PeopleDataAdapter(inflater, items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onEventsClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.EVENTS_FRAGMENT);
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
