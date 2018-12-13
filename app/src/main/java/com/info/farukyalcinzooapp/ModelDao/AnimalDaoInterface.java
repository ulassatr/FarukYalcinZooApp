package com.info.farukyalcinzooapp.ModelDao;

import com.info.farukyalcinzooapp.Models.Animal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AnimalDaoInterface {

    @GET("Animal/GetAll")
    Call<List<Animal>> GetAllAnimal();

    @GET("Animal/GetAnimalById/{id}")
    Call<Animal> GetAnimalById(@Path("id") int id);
}
