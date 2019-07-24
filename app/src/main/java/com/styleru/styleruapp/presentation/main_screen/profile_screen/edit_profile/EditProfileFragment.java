package com.styleru.styleruapp.presentation.main_screen.profile_screen.edit_profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.LinkItem;
import com.styleru.styleruapp.presentation.main_screen.profile_screen.ProfileModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EditProfileFragment extends MvpAppCompatFragment implements EditProfileView {
    @InjectPresenter EditProfilePresenter mPresenter;
    @Inject Provider<EditProfilePresenter> mProvider;
    @ProvidePresenter EditProfilePresenter getPresenter() {return mProvider.get();}
    @BindView(R.id.email_edit_text) EditText mEmailEditText;
    @BindView(R.id.phone_edit_text) EditText mPhoneEditText;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.profile_edit_links_recycler_view) RecyclerView mRecyclerView;
    private MenuItem mSelectedItem;
    private boolean mIsBottomItemSelected = true;


    Unbinder mUnbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mPresenter.provideData();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mBottomNavigationView.setSelectedItemId(R.id.profile_menu);
        mBottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem menuItem)-> {
            if (mIsBottomItemSelected){
                mSelectedItem = menuItem;
                leaveScreen();
            }
            return true;
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showData(ProfileModel model) {
        mEmailEditText.setText(model.getEmail());
        mPhoneEditText.setText(model.getPhoneNumber());
        List<LinkItem> list = model.getLinks();
        if (mRecyclerView.getAdapter()==null) mRecyclerView.setAdapter(new EditProfileAdapter(getLayoutInflater(), list));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    private void leaveScreen(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.save_changes)
                .setNeutralButton(R.string.cancel, mCancelOnClickListener)
                .setNegativeButton(R.string.no, mNegativeOnClickListener)
                .setPositiveButton(R.string.yes, mPositiveOnClickListener);
        builder.create().show();
    }

    DialogInterface.OnClickListener mNegativeOnClickListener = (dialog, which)-> {
        mPresenter.changeScreen(mSelectedItem);
        //dialog.dismiss();
        };
    DialogInterface.OnClickListener mPositiveOnClickListener = (dialog, which)-> {
        mPresenter.changeScreen(mSelectedItem);
        //
        //here sh
        //
        //dialog.cancel();
    };
    DialogInterface.OnClickListener mCancelOnClickListener = (dialog, which)-> {
        mSelectedItem = null;
        mIsBottomItemSelected = false;
        dialog.cancel();
        mBottomNavigationView.setSelectedItemId(R.id.profile_menu);
        mIsBottomItemSelected = true;
    };

}
