package com.info.farukyalcinzooapp;

import com.info.farukyalcinzooapp.ModelDao.AnimalDaoInterface;

public class ApiUtils {
   // public static final String BASE_URL = "http://192.168.1.27:9000/api/";

  // public static final String BASE_URL = "http://10.0.2.2:9000/api/";
  public static final String BASE_URL = "http://192.168.1.6:9000/api/";

    public static AnimalDaoInterface getAnimalDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(AnimalDaoInterface.class);
    }
}
