package com.info.farukyalcinzooapp.ModelDao;

import com.info.farukyalcinzooapp.Models.Animal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalDaoInterface {
    @GET("Animal/GetAll")
    Call<List<Animal>> allAnimal();
}
