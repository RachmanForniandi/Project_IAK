package com.example.android.project_iak.mainhome;

import android.content.Context;
import android.widget.Toast;

import com.example.android.project_iak.Interactor.HomeInterface;
import com.example.android.project_iak.R;
import com.example.android.project_iak.model.ExampleRetro;
import com.example.android.project_iak.model.HomeModel;
import com.example.android.project_iak.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 5/14/2017.
 */

public class HomePresenter implements HomeInterface{

    private Context mContext;
    private HomeActivity mHomeInterface;
    private ArrayList<HomeModel> mHomeModels;
    private List<ExampleRetro> mExampleRetros;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";

    public HomePresenter(HomeActivity mHomeInterface, Context mContext){
        this.mHomeInterface = mHomeInterface;
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel>homeModels) {
        mHomeModels = homeModels;
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
        Call<List<ExampleRetro>> call = serviceApi.getData();
        call.enqueue(new Callback<List<ExampleRetro>>() {
            @Override
            public void onResponse(Call<List<ExampleRetro>> call, Response<List<ExampleRetro>> response) {
                mExampleRetros = response.body();
                for (int i = 0; i < mExampleRetros.size() ; i++) {
                    String judul = mExampleRetros.get(i).getJudul();
                    String tipe = mExampleRetros.get(i).getTentang();
                    String isi = mExampleRetros.get(i).getIsi();
                    mHomeModels.add(new HomeModel(judul,"Genre :"+tipe," Deskripsi :",isi));
                }
                mHomeInterface.initView();
            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
