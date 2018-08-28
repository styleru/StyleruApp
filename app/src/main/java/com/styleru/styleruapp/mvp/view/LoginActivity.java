package com.styleru.styleruapp.mvp.view;

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
import com.styleru.styleruapp.Old.Items.CategoryPagerActivity;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.mvp.model.LoginInfo;
import com.styleru.styleruapp.mvp.interfaces.LoginView;
import com.styleru.styleruapp.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends MvpAppCompatActivity implements LoginView {
    public static final String APP_PREFERENCES = "settings";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ACCESS_TOKEN = "token";
    @InjectPresenter
    LoginPresenter mLoginPresenter;

    @BindView(R.id.login_edit_text) EditText mLoginEditText;

    @BindView(R.id.password_edit_text) EditText mPasswordEditText;

    @BindView(R.id.forget_text_view) TextView mForgetTextView;

    @BindView(R.id.enter_button) Button mEnterButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init(){
        ButterKnife.bind(this);
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.signIn();
            }
        });
        mForgetTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetPassword();
            }
        });
    }

    @Override
    public void newIntent() {
        Intent intent = new Intent(LoginActivity.this, CategoryPagerActivity.class); //viewpager should be replaced
        startActivity(intent);
    }

    @Override
    public LoginInfo getLoginData() {
        LoginInfo loginInfo = new LoginInfo(mLoginEditText.getText().toString(),
                mPasswordEditText.getText().toString());
        return loginInfo;
    }

    @Override
    public void passData(LoginInfo loginInfo) {
        SharedPreferences sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(LOGIN, loginInfo.getLogin())
                .putString(PASSWORD, loginInfo.getPassword())
                .putString(ACCESS_TOKEN, loginInfo.getToken())
                .apply();

    }

    @Override
    public void forgetPassword() {

    }
}
