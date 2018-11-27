package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.navigation.StyleruNavigator;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ParticularEventFragment extends MvpAppCompatFragment implements ParticularEventView {
    @InjectPresenter ParticularEventPresenter mPresenter;
    @Inject Provider<ParticularEventPresenter> mProvidePresenter;
    @ProvidePresenter
    ParticularEventPresenter providePresenter(){return mProvidePresenter.get();}
    @BindView(R.id.event_image_view) ImageView mImageView;
    @BindView(R.id.particular_event_toolbar) android.support.v7.widget.Toolbar mToolbar;
    Unbinder mUnbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.particular_event_fragment, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        String id = getArguments().getString(StyleruNavigator.ID);
        mPresenter.provideData(id);

    }

    @Override
    public void showData(EventItem item) {
        mToolbar.setTitle(item.getTitle());
        Glide.with(this).load(item.getImage())
                .into(mImageView);
    }
}
