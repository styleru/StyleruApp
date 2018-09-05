package com.styleru.styleruapp.login_activity.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.login_activity.StyleruApplication;
import com.styleru.styleruapp.Old.Items.CategoryPagerActivity;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.login_activity.model.LoginInfo;
import com.styleru.styleruapp.login_activity.interfaces.LoginView;
import com.styleru.styleruapp.login_activity.presenter.LoginPresenter;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class LoginActivity extends MvpAppCompatActivity implements LoginView {
    public static final String APP_PREFERENCES = "settings";
    public static final String ACCESS_TOKEN = "token";

    @BindView(R.id.login_edit_text) EditText mLoginEditText;

    @BindView(R.id.password_edit_text) EditText mPasswordEditText;

    @BindView(R.id.forget_text_view) TextView mForgetTextView;

    @BindView(R.id.enter_button) Button mEnterButton;

    @InjectPresenter
    LoginPresenter presenter;
    @Inject
    Provider<LoginPresenter> presenterProvider;

    @ProvidePresenter
    LoginPresenter providePresenter(){
        return presenterProvider.get();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        StyleruApplication.getAppComponent().inject(this);
        init();
    }

    public void init(){
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = mLoginEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                //boolean isInfoCorrect= presenter.signIn(login, password);
                //if (isInfoCorrect) newIntent();
            }
        });
        mForgetTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //forgetPassword();
            }
        });
    }
@Inject
    public void newIntent() {
        Intent intent = new Intent(LoginActivity.this, CategoryPagerActivity.class); //viewpager should be replaced
        startActivity(intent);
    }

    @Override
    public void passData(LoginInfo loginInfo) {
        SharedPreferences sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(ACCESS_TOKEN, loginInfo.getToken())
                .apply();

    }
/*
    @Override
    public void forgetPassword() {
    }*/
}
