package com.styleru.styleruapp.presentation.main_screen.people_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeopleFragment extends MvpAppCompatFragment implements PeopleView {
    @InjectPresenter PeoplePresenter mPresenter;
    @Inject Provider<PeoplePresenter> mProvider;
    @ProvidePresenter PeoplePresenter getPresenter(){return mProvider.get();}
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        ButterKnife.bind(this, view);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            mPresenter.changeScreen(menuItem);
            return true;
        });
        return view;
    }
}
