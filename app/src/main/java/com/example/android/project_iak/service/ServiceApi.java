package com.example.android.project_iak.service;

import com.example.android.project_iak.model.ExampleRetro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lenovo on 5/14/2017.
 */

public interface ServiceApi {

    String END_POINT = "questions";

    @GET(END_POINT)
    Call<List<ExampleRetro>>getData();
}
