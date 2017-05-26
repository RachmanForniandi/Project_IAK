package com.example.android.project_iak.mainhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.project_iak.Adapter.HomeAdapter;
import com.example.android.project_iak.Interactor.HomeInterface;
import com.example.android.project_iak.R;
import com.example.android.project_iak.model.HomeModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements HomeInterfaceActivity{
    private TextView Tvtitle;
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private HomeInterface mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent mIntent = getIntent();
        setTitle("Selamat Data"+ mIntent.getStringExtra("username")+ "di Project IAK 2017");

        mHomeInterface = new HomePresenter(this,this);
        mHomeModel = new ArrayList<>();
        mHomeInterface.showList(mHomeModel);
        mHomeInterface.getData();
    }

    public void initView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(HomeActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(this, mHomeModel);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void setInfo(String title,String body){

    }

    @Override
    public void next(int id){
        Intent intent = new Intent();
        intent.putExtra("id",id);
        startActivity(intent);

    }
}
