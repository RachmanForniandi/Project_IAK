package com.example.android.project_iak.mainDetail;

import android.content.Context;
import android.widget.Toast;

import com.example.android.project_iak.Interactor.DetailDataInterface;
import com.example.android.project_iak.R;
import com.example.android.project_iak.model.ExampleRetro;
import com.example.android.project_iak.service.ServiceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 5/26/2017.
 */

public class DetailInterfacePresenter implements DetailDataInterface{
    private com.example.android.project_iak.mainhome.HomeInterfaceActivity HomeInterfaceActivity;
    private List<ExampleRetro> mExamplRetros;
    private Context mContext;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private String ids;

    public DetailInterfacePresenter(DetailActivity homeInterfaceActivity, Context mContext){
        HomeInterfaceActivity =(com.example.android.project_iak.mainhome.HomeInterfaceActivity)homeInterfaceActivity;
        this.mContext = mContext;
    }

    @Override
    public void getDataInfo(String id) {
        final String ids = id;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
        Call<List<ExampleRetro>> call = serviceApi.getData();
        call.enqueue(new Callback<List<ExampleRetro>>() {
            @Override
            public void onResponse(Call<List<ExampleRetro>> call, Response<List<ExampleRetro>> response) {
                mExamplRetros = response.body();
                String judul = mExamplRetros.get(Integer.parseInt(ids)).getJudul();
                String tipe = mExamplRetros.get(Integer.parseInt(ids)).getTentang();
                String isi = mExamplRetros.get(Integer.parseInt(ids)).getIsi();
                HomeInterfaceActivity.setInfo(judul, "\n Tipe: " + tipe + " \n Isi:" + isi);
            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
