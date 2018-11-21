package com.styleru.styleruapp.presentation.main_screen;

import android.os.Bundle;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.styleru.styleruapp.R;
import com.styleru.styleruapp.StyleruApplication;
import com.styleru.styleruapp.presentation.BaseActivity;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainActivity extends BaseActivity implements MvpView {
    @InjectPresenter
    MainActivityPresenter mPresenter;
    @Inject
    Provider<MainActivityPresenter> mPresenterProvider;
    @ProvidePresenter
    MainActivityPresenter providePresenter(){return mPresenterProvider.get();}
    public MainActivity(){
        super(R.id.fragment_container);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StyleruApplication.getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        mPresenter.changeScreen();
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.homeAsUp:
                onBackPressed();
            case R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }*/
}
