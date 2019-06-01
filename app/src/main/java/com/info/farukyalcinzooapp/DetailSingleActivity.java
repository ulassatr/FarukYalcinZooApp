package com.info.farukyalcinzooapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.farukyalcinzooapp.ModelDao.AnimalDaoInterface;
import com.info.farukyalcinzooapp.Models.Animal;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSingleActivity extends AppCompatActivity {
    private Animal animal;
    private AnimalDaoInterface animalDao;
    private ImageView detay_resim;
    private TextView detay_baslik;
    private  TextView detay_aciklama;
    private Button detay_map;
    private Context context;

    public DetailSingleActivity() {

    }

    public DetailSingleActivity(Context context) {
        this.context = context;

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detay_single_tasarim);
        detay_resim = (ImageView)findViewById(R.id.animal_imageSin);
        detay_baslik = (TextView) findViewById(R.id.animal_nameDsin);
        detay_aciklama = (TextView) findViewById(R.id.animal_descSin);
        detay_map = (Button) findViewById(R.id.button_mapSin);

        String s = getIntent().getExtras().getString("detailId");

        int id = Integer.parseInt(s);

        animalDao = ApiUtils.getAnimalDaoInterface();
        GetAnimalById(id);

    }

    public void GetAnimalById(int id){
        animalDao.GetAnimalById(id).enqueue(new Callback<Animal>() {
            @Override
            public void onResponse(Call<Animal> call, Response<Animal> response) {
                animal = response.body();
                detay_baslik.setText(animal.getName());
                detay_aciklama.setText(animal.getDescription());

                Picasso.get()
                        .load(R.drawable.inek)
                        .resize(200,300)
                        .into(detay_resim);
                detay_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DetailSingleActivity.this,MapsActivity.class);
                        intent.putExtra("nesne",animal);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Animal> call, Throwable t) {

            }
        });
    }
}
