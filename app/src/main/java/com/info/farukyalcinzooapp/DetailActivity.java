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


public class DetailActivity extends AppCompatActivity {
    private ImageView detay_resim;
    private TextView detay_baslik;
    private  TextView detay_aciklama;
    private Button detay_map;
    private Animal animal;
    private Context context;

    public DetailActivity() {

    }

    public DetailActivity(Context context) {
        this.context = context;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detay_tasarim);

        detay_resim = (ImageView)findViewById(R.id.animal_image);
        detay_baslik = (TextView) findViewById(R.id.animal_nameD);
        detay_aciklama = (TextView) findViewById(R.id.animal_desc);
        detay_map = (Button) findViewById(R.id.button_map);


        animal = (Animal) getIntent().getSerializableExtra("nesne");
        detay_baslik.setText(animal.getName());
        detay_aciklama.setText(animal.getDescription());

        Picasso.get()
                .load(R.drawable.inek)
                .resize(200,300)
                .into(detay_resim);
        detay_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,MapsActivity.class);
                intent.putExtra("nesne",animal);
                startActivity(intent);
            }
        });

    }


}



