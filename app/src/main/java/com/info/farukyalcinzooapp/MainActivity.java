package com.info.farukyalcinzooapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.info.farukyalcinzooapp.ModelDao.AnimalDaoInterface;
import com.info.farukyalcinzooapp.Models.Animal;
import com.info.farukyalcinzooapp.fragments.FragmentBirinci;
import com.info.farukyalcinzooapp.fragments.FragmentIkinci;
import com.info.farukyalcinzooapp.fragments.FragmentUcuncu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AnimalDaoInterface animalDao;
    private NavigationView nav_view;
    private Toolbar toolbar;
    private Fragment fragment;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalDao = ApiUtils.getAnimalDaoInterface();
        allAnimals();

        fragment = new FragmentBirinci();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu,fragment).commit();

        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);

    drawer.addDrawerListener(toogle);
    toogle.syncState();

        View baslik = nav_view.inflateHeaderView(R.layout.nav_baslik);

        nav_view.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        if(id==R.id.action_fotogal){
            allAnimals();
            fragment = new FragmentBirinci();
        }
        if(id==R.id.action_plants){
            fragment = new FragmentIkinci();
        }
        if(id==R.id.action_animals){
            fragment = new FragmentUcuncu();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,fragment).commit();

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
//            Eğer drawer açıksa kapatan kod parçası
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
//            Geri tuşuna basıldığında ana ekrana dönmesini sağlayaan kod parçası
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);
        }
    }
    public void allAnimals(){
        animalDao.allAnimal().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

                List<Animal> list = response.body();
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {
        Log.e("asadas","asd");
            }
        });
    }
}
