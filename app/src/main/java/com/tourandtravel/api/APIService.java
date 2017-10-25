package com.tourandtravel.api;

import com.tourandtravel.model.CustomerLoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by gagan.mathur on 9/4/2017.
 */

public interface APIService {

    @POST("maestrotravel_login.php")
    @FormUrlEncoded

    Call<CustomerLoginModel> loginPost(
            @Field("user_name") String user_name,
            @Field("password") String password,
            @Field("token") String token);


}
