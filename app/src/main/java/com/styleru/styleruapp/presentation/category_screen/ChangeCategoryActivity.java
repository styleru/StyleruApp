package com.styleru.styleruapp.presentation.category_screen;

import android.os.Bundle;

import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.presentation.BaseActivity;

public class ChangeCategoryActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_category);
    }


}
