package com.styleru.styleruapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class LoginActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "settings";
    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String ACCESS_TOKEN = "token";
    private String mLogin;
    private String mPassword;


    private final String SAMPLE_LOGIN = "guest";
    private final String SAMPLE_PASSWORD = "1234";
    private final String SAMPLE_TOKEN = "1m3kn1z9jhui";


    @BindView(R.id.login_edit_text) EditText mLoginEditText;

    @BindView(R.id.password_edit_text) EditText mPasswordEditText;

    @BindView(R.id.forget_text_view) TextView mForgetTextView;

    @BindView(R.id.enter_button) Button mEnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();
        if (savedInstanceState != null){
            mLoginEditText.setText(savedInstanceState.getString(LOGIN));
            mPasswordEditText.setText(savedInstanceState.getString(PASSWORD));
        }
    }

    private void init(){
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            // fake auth will be replaced
            @Override
            public void onClick(View view) {
                mLogin = mLoginEditText.getText().toString();
                mPassword = mPasswordEditText.getText().toString();
                if (mLogin.equals(SAMPLE_LOGIN) && mPassword.equals(SAMPLE_PASSWORD)){
                    SharedPreferences sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
                    sharedPreferences.edit()
                            .putString(LOGIN, mLogin)
                            .putString(PASSWORD, mPassword)
                            .putString(ACCESS_TOKEN, SAMPLE_TOKEN)
                            .apply();

                    Intent intent = CategoryPagerActivity.createCategoryPagerActivity(LoginActivity.this);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LOGIN, mLoginEditText.getText().toString());
        savedInstanceState.putString(PASSWORD, mPasswordEditText.getText().toString());

    }
}
