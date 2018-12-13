package com.info.farukyalcinzooapp;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.info.farukyalcinzooapp.ModelDao.AnimalDaoInterface;
import com.info.farukyalcinzooapp.Models.Animal;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalActivity extends MainActivity implements Button.OnClickListener{
    private Button btnMammal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);


        btnMammal = findViewById(R.id.btnMammal);

        btnMammal.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.btnMammal){
            try {

                Intent intent = new Intent(AnimalActivity.this,MammalActivity.class);
                startActivity(intent);

            }
            catch (Exception ex){
                Log.e("error",ex.toString());
            }

        }
    }
}
