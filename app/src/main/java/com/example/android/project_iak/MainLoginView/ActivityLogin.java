package com.example.android.project_iak.MainLoginView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.project_iak.Interactor.LoginInterface;
import com.example.android.project_iak.R;
import com.example.android.project_iak.mainhome.HomeActivity;


public class ActivityLogin extends AppCompatActivity implements LoginInterface {
    private EditText mTxtUsername;
    private EditText mTxtPassword;
    private Button mButtonLogin;
    private LoginInterfacePresenter mLoginInterfacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtUsername = (EditText)findViewById(R.id.txt_username);
        mTxtPassword= (EditText)findViewById(R.id.txt_password);
        mButtonLogin= (Button)findViewById(R.id.btn_login);

        mLoginInterfacePresenter = new LoginPresenter(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mLoginInterfacePresenter.login(mTxtUsername.getText().toString(),
                        mTxtPassword.getText().toString());
            }
        });
    }

    @Override
    public void showError(){

    }

    @Override
    public void MessageError(){
        Toast.makeText(this,R.string.loginempty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError(){
        Toast.makeText(this,R.string.logininvalid, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String username){
        Toast.makeText(this, R.string.loginsukses, Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, HomeActivity.class);
        intent.putExtra("username", mTxtUsername.getText().toString());
        startActivity(intent);
    }

}
