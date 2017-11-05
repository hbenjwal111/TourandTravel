package com.tourandtravel.api;

import com.tourandtravel.model.ClusterList;
import com.tourandtravel.model.CommonList;
import com.tourandtravel.model.CustomerLoginModel;
import com.tourandtravel.model.CustomerRegisterModel;
import com.tourandtravel.model.HotelList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by gagan.mathur on 9/4/2017.
 */

public interface APIService {

    @POST("/api/maestrotravel_login.php")
    @FormUrlEncoded
    Call<CustomerLoginModel> loginPost(
            @Field("username") String username,
            @Field("password") String password
    );


    @POST("/api/maestrotravel_signup.php")
    @FormUrlEncoded
    Call<CustomerRegisterModel> registerPost(

            @Field("username") String username,
            @Field("password") String password,
            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone);


    @POST("/api/maestrotravel_cluster.php")
    @FormUrlEncoded
    Call<ClusterList> getAllCluster(

            @Field("cluster_id") Integer cluster_id,
            @Field("clus_title") String clus_title,
            @Field("clus_discription") String clus_discription,
            @Field("clus_image") String clus_image

    );

    @POST("/api/maestrotravel_cluster_detail.php")
    @FormUrlEncoded

    Call<CommonList> getClusterDetail(

            @Field("cluster_id") Integer cluster_id


    );

    @POST("/api/maestrotravel_hotel.php")
    @FormUrlEncoded


    Call<HotelList> getHotelList(
            @Field("cluster_id") Integer cluster_id);

}