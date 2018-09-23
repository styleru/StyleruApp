package com.styleru.styleruapp.presentation.login_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.StyleruApplication;
//import com.styleru.styleruapp.Old.Items.CategoryPagerActivity;
import com.styleru.styleruapp.R;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class LoginActivity extends MvpAppCompatActivity implements LoginView {

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
        StyleruApplication.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    public void init(){
        mEnterButton.setOnClickListener(v -> {
            String login = mLoginEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            presenter.signIn(login, password);
        });
    }
}
