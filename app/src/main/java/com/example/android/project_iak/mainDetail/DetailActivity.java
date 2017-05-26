package com.example.android.project_iak.mainDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.project_iak.Interactor.DetailDataInterface;
import com.example.android.project_iak.R;
import com.example.android.project_iak.mainhome.HomeInterfaceActivity;

public class DetailActivity extends AppCompatActivity implements HomeInterfaceActivity{

    private TextView detaildata;
    private DetailDataInterface mDetailInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(R.string.loading);
        Intent intent = getIntent();
        String i = intent.getStringExtra("id");
        mDetailInterface = new DetailInterfacePresenter(this,this);
        mDetailInterface.getDataInfo(i);
    }

    @Override
    public void initView(){

    }

    @Override
    public void next(int id){

    }

    @Override
    public void setInfo(String title, String body){
        setTitle(title);
        detaildata = (TextView)findViewById(R.id.mTVdetail);
        detaildata.setText(body);
    }
}
