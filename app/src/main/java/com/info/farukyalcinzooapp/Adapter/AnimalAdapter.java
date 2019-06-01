package com.info.farukyalcinzooapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.info.farukyalcinzooapp.AnimalActivity;
import com.info.farukyalcinzooapp.DetailActivity;
import com.info.farukyalcinzooapp.MammalActivity;
import com.info.farukyalcinzooapp.Models.Animal;
import com.info.farukyalcinzooapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.CardTasarimTutucu>{
private Context context;
private List<Animal> animalList;
private Animal animal;

    public AnimalAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }



    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private ImageView animal_resim;
        private TextView animal_name;
        private Button animal_detay;




        public CardTasarimTutucu(View view) {
            super(view);
            animal_resim = view.findViewById(R.id.animal_resim);
            animal_name = view.findViewById(R.id.animal_nameD);
            animal_detay = view.findViewById(R.id.button_detay);

        }
    }


    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_card_tasarim,viewGroup,false);
        return new CardTasarimTutucu(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu cardTasarimTutucu, int i) {
        Animal animal = animalList.get(i);

        cardTasarimTutucu.animal_name.setText(animal.getName());

        String path = animal.getImagePath();
        File imgFile = new File(path);

        Picasso.get().
                load(R.drawable.inek).
                into(cardTasarimTutucu.animal_resim);


        cardTasarimTutucu.animal_detay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("nesne",animal);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }


}
