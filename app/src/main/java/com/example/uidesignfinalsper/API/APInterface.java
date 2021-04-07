package com.example.uidesignfinalsper.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface APInterface {

        @GET("/api/v1/animals")
        Call<QueryObj> getAnimals();

}

