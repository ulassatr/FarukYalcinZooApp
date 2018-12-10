package com.info.farukyalcinzooapp;

import com.info.farukyalcinzooapp.ModelDao.AnimalDaoInterface;

public class ApiUtils {
    public static final String BASE_URL = "http://10.3.14.126:9000/api/";

    public static AnimalDaoInterface getAnimalDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(AnimalDaoInterface.class);
    }
}
