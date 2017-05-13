package com.example.android.project_iak.MainView;

import android.text.TextUtils;

import com.example.android.project_iak.Interactor.InterfaceMain;
import com.example.android.project_iak.Interactor.InterfacePresenter;

/**
 * Created by Lenovo on 5/13/2017.
 */

public class MainPresenter implements InterfacePresenter{
    private InterfaceMain mInterfaceMain;

    public MainPresenter(InterfaceMain mInterfaceMain){
        this.mInterfaceMain = mInterfaceMain;
    }

    @Override
    public void login(String username, String password){
        if (TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            mInterfaceMain.loginError();
        }else{
            if (username.equals("Rachman")&& password.equals("Forniandi")){
                mInterfaceMain.loginSuccess();
            }else{
                mInterfaceMain.loginError();
            }
        }
    }

}
