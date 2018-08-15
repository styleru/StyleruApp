package com.styleru.styleruapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity {
    private final String SAMPLE_LOGIN = "guest";
    private final String SAMPLE_PASSWORD = "1234";

    @BindView(R.id.login_edit_text)
    private EditText mLoginEditText;

    @BindView(R.id.password_edit_text)
    private EditText mPasswordEditText;

    @BindView(R.id.forget_text_view)
    private EditText mForgetTextView;

    @BindView(R.id.enter_button)
    private Button mEnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        ButterKnife.bind(this);

        mEnterButton.setOnClickListener(new View.OnClickListener() {
            // fake auth will be replaced
            @Override
            public void onClick(View view) {
                if (mLoginEditText.getText().toString().equals(SAMPLE_LOGIN) && mPasswordEditText.getText().toString().equals(SAMPLE_PASSWORD)){
                    
                }
            }
        });
    }

}
