package com.styleru.styleruapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CategoryFragment extends Fragment {
    private Unbinder mUnbinder;
    @BindView(R.id.category_layout) LinearLayout mLinearLayout;

    private final String CATEGORIES[] = {"Android", "IOS", "Web", "Design"};

    public static Fragment newInstance(){
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        //LayoutInflater layoutInflater = getLayoutInflater();
        //getActivity().setTitle("Направления");
        getActivity().setTitle(Html.fromHtml("<font color='#ffffff'>Направления </font>"));
        for (String element:
                CATEGORIES) {
            View item = inflater.inflate(R.layout.item_category, mLinearLayout, false);
            TextView directionName = item.findViewById(R.id.category_name);
            directionName.setText(element);
            //item.getLayoutParams().height = LinearLayout.LayoutParams.MATCH_PARENT;
            //item.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
            mLinearLayout.addView(item);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
