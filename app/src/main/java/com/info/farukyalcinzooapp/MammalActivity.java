package com.info.farukyalcinzooapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.info.farukyalcinzooapp.Adapter.AnimalAdapter;
import com.info.farukyalcinzooapp.ModelDao.AnimalDaoInterface;
import com.info.farukyalcinzooapp.Models.Animal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MammalActivity extends AppCompatActivity {
    private AnimalDaoInterface animalDao;
    private List<Animal> res ;



    private RecyclerView rv;
    private AnimalAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mammal_layout);

        rv= findViewById(R.id.rv);
        //ekran boyutu değişse de sıkıntı olmaz.
        rv.setHasFixedSize(true);
        //2 tane gözüksün yanyana
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


        animalDao = ApiUtils.getAnimalDaoInterface();
        GetAllAnimal();


    }

  public void GetAllAnimal(){
        animalDao.GetAllAnimal().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
               res = response.body();

                adapter = new AnimalAdapter(getApplicationContext(),res);

                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

            }
        });
  }




}
