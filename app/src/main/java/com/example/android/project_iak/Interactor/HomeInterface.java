package com.example.android.project_iak.Interactor;

import com.example.android.project_iak.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by Lenovo on 5/14/2017.
 */

public interface HomeInterface {
    void showList(ArrayList<HomeModel>homeModels);
    void getData();
}
