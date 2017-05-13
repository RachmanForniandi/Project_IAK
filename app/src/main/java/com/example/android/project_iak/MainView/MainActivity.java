package com.example.android.project_iak.MainView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.project_iak.Interactor.InterfaceMain;
import com.example.android.project_iak.Interactor.InterfacePresenter;
import com.example.android.project_iak.R;


public class MainActivity extends AppCompatActivity implements InterfaceMain{
    private EditText mTxtUsername;
    private EditText mTxtPassword;
    private Button mButtonLogin;
    private InterfacePresenter mInterfacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtUsername = (EditText)findViewById(R.id.txt_username);
        mTxtPassword= (EditText)findViewById(R.id.txt_password);
        mButtonLogin= (Button)findViewById(R.id.btn_login);

        mInterfacePresenter = new MainPresenter(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mInterfacePresenter.login(mTxtUsername.getText().toString(),
                        mTxtPassword.getText().toString());
            }
        });
    }

    @Override
    public void showError(){

    }

    @Override
    public void MessageError(){
        Toast.makeText(this,"Maaf, Username atau Password tidak boleh kosong", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError(){
        Toast.makeText(this,"Maaf, Username atau Password anda SALAH !!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess(){
        Toast.makeText(this,"Login Berhasil. Selamat Datang User.", Toast.LENGTH_LONG).show();
        Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("username", mTxtUsername.getText().toString());
        intent.putExtra("password", mTxtPassword.getText().toString());
        startActivity(intent);
    }

}
