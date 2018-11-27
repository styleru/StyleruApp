package com.styleru.styleruapp.presentation.main_screen.events_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.bumptech.glide.Glide;
import com.styleru.styleruapp.R;

public class ParticularEventFragment extends MvpAppCompatFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.particular_event_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.event_image_view);
        Glide.with(this).load("https://nashzeleniymir.ru/wp-content/uploads/2016/02/%D0%96%D0%B0%D0%B1%D0%B0-%D1%84%D0%BE%D1%82%D0%BE-1024x683.jpg")
                .into(imageView);
    }
}
