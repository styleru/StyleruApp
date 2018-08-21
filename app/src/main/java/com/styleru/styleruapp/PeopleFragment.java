package com.styleru.styleruapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.styleru.styleruapp.Items.ProfileItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PeopleFragment extends Fragment {
    Unbinder mUnbinder;
    @BindView(R.id.single_recycler_view)
    RecyclerView mRecyclerView;

    public static Fragment newInstance(){
        PeopleFragment fragment = new PeopleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_recycler_view, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        ProfileItem sampleProfile = new ProfileItem("dolphin", "web", "https://pp.userapi.com/c847123/v847123031/156d/kxJRy2z3nOA.jpg");
        List<ProfileItem> mProfiles = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            mProfiles.add(sampleProfile);
        }
        PeopleDataAdapter adapter = new PeopleDataAdapter(inflater, mProfiles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
