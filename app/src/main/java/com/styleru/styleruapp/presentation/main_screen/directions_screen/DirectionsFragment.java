package com.styleru.styleruapp.presentation.main_screen.directions_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DirectionsFragment extends MvpAppCompatFragment implements DirectionsView {
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.category_layout) LinearLayout mLinearLayout;
    @InjectPresenter DirectionsPresenter mPresenter;
    @Inject Provider<DirectionsPresenter> mProvidePresenter;
    @ProvidePresenter DirectionsPresenter provideDirectionPresenter(){return mProvidePresenter.get();}
    Unbinder mUnbinder;

    private final String CATEGORIES[] = {"Android", "IOS", "Web", "Design"};

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
        for (String element:
                CATEGORIES) {
            View item = inflater.inflate(R.layout.item_category, mLinearLayout, false);
            TextView directionName = item.findViewById(R.id.category_name);
            directionName.setText(element);
            mLinearLayout.addView(item);
        }
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

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
