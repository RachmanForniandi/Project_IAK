package com.example.android.project_iak.mainhome;

import android.content.Context;

import com.example.android.project_iak.Interactor.HomeInterface;
import com.example.android.project_iak.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by Lenovo on 5/14/2017.
 */

public class HomePresenter implements HomeInterface{

    private Context mContext;
    private ArrayList<HomeModel> mHomeModels;

    public HomePresenter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel>homeModels){
        mHomeModels = homeModels;

        mHomeModels.add(new HomeModel("Firman","Jakarta","FirmanMujahiddin@gmail.com","08989725807"));
        mHomeModels.add(new HomeModel("Arya","Jakarta","arya@gmail.com","08547736235"));
        mHomeModels.add(new HomeModel("Martin","Tangerang","Martin@gmail.com","08577723467"));
        mHomeModels.add(new HomeModel("Samuel","Tangerang","samuel@gmail.com","08989725807"));
        mHomeModels.add(new HomeModel("Rachman","Tangerang","rachmanforniandi@gmail.com","085732737500"));
        mHomeModels.add(new HomeModel("Venta","jakarta","venta@gmail.com","085477362353"));
        mHomeModels.add(new HomeModel("Rindang","jakarta","Rindang@gmail.com","08989725807"));
    }
}
