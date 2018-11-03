package com.styleru.styleruapp.presentation.main_screen.directions_screen;

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

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DirectionsFragment extends MvpAppCompatFragment implements DirectionsView {
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.directions_recycler_view) RecyclerView mRecyclerView;
    @InjectPresenter DirectionsPresenter mPresenter;
    @Inject Provider<DirectionsPresenter> mProvidePresenter;
    @ProvidePresenter DirectionsPresenter provideDirectionPresenter(){return mProvidePresenter.get();}
    Unbinder mUnbinder;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            StyleruApplication.getAppComponent().inject(this);
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_directions, container, false);

            mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNavigationView.setSelectedItemId(R.id.directions_menu);

        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)->{
            mPresenter.changeScreen(menuItem);
            return true;}
        );
        mPresenter.provideData();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void showData(List<DirectionsItem> items) {
            LayoutInflater inflater = getLayoutInflater();
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.setAdapter(new DirectionsDataAdapter(inflater, items));
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
    public void onProfileClicked(StyleruRouter router) {
        router.replaceScreen(ScreenKeys.PROFILE_FRAGMENT);
    }
}
