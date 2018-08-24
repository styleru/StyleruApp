package com.styleru.styleruapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SharedMemory;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryPagerActivity extends AppCompatActivity {
    @BindView(R.id.category_view_pager) ViewPager mViewPager;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;

    public static Intent createCategoryPagerActivity(Context packageContext){
        Intent intent = new Intent(packageContext, CategoryPagerActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_pager);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.APP_PREFERENCES, MODE_PRIVATE);
        if (sharedPreferences.getString(LoginActivity.ACCESS_TOKEN, null)== null){
            Intent intent = new Intent(CategoryPagerActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void init(){
        ButterKnife.bind(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        setTitle(Html.fromHtml("<font color='#ffffff'>Направления </font>"));
                        return CategoryFragment.newInstance();
                    case 1:
                        return PeopleFragment.newInstance();
                    case 2:
                        return EventsFragment.newInstance();
                    case 3:
                        return ProfileFragment.newInstance();

                }
            return null;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        setTitle(Html.fromHtml("<font color='#ffffff'>Направления </font>"));
                        break;
                    case 1:
                        setTitle(Html.fromHtml("<font color='#ffffff'>Люди </font>"));
                        break;
                    case 2:
                        setTitle(Html.fromHtml("<font color='#ffffff'>Мероприятия </font>"));
                        break;
                    case 3:
                        setTitle(Html.fromHtml("<font color='#ffffff'>Профиль </font>")); // need to use sharedPreferences to get username
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.category_menu:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.people_menu:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.events_menu:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.profile_menu:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}
