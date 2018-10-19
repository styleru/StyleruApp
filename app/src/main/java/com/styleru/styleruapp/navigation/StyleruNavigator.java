package com.styleru.styleruapp.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.styleru.styleruapp.presentation.category_screen.ChangeCategoryActivity;

import ru.terrakok.cicerone.android.SupportAppNavigator;

public class StyleruNavigator extends SupportAppNavigator {

    public StyleruNavigator(FragmentActivity activity, int containerId) {
        super(activity, containerId);
    }


    @Override
    public Intent createActivityIntent(Context context, String screenKey, Object data) {
        Intent intent = null;
        switch (screenKey){
            case ScreenKeys.CATEGORY_ACTIVITY:
                intent =  new Intent(context, ChangeCategoryActivity.class);
        }
        return intent;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        return null;
    }
}
