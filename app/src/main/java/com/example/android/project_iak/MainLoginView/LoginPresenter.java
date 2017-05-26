package com.example.android.project_iak.MainLoginView;

import android.text.TextUtils;

import com.example.android.project_iak.Interactor.LoginInterface;

/**
 * Created by Lenovo on 5/13/2017.
 */

public class LoginPresenter implements LoginInterfacePresenter{
    private LoginInterface mLoginInterface;

    public LoginPresenter(LoginInterface mLoginInterface){
        this.mLoginInterface = mLoginInterface;
    }

    @Override
    public void login(String username, String password){
        if (TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            mLoginInterface.loginError();
        }else{
            if (username.equals("Rachman")&& password.equals("Forniandi")){
                mLoginInterface.loginSuccess(username);
            }else{
                mLoginInterface.loginError();
            }
        }
    }

}
