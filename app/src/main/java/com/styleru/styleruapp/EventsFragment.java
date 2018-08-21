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

import com.styleru.styleruapp.Items.EventItem;
import com.styleru.styleruapp.Items.ProfileItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EventsFragment extends Fragment{
    private Unbinder mUnbinder;
    @BindView(R.id.single_recycler_view)
    RecyclerView mRecyclerView;

    public static Fragment newInstance(){
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_recycler_view, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        EventItem sampleProfile = new EventItem("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Bufotes_oblongus.jpg/275px-Bufotes_oblongus.jpg", "java meetup", "31.12.2018", "red square");
        List<EventItem> mProfiles = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            mProfiles.add(sampleProfile);
        }
        EventDataAdapter adapter = new EventDataAdapter(inflater, mProfiles);
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
