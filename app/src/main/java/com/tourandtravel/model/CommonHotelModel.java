package com.tourandtravel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 05-11-2017.
 */

public class CommonHotelModel {


   /* @SerializedName("cluster_id")
    @Expose
    private Integer cluster_id;*/

    @SerializedName("hotel_id")
    @Expose
    private String hotel_id;


    @SerializedName("name")
    @Expose

    private String name;

    @SerializedName("district")
    @Expose

    private String district;

    @SerializedName("hotel_image")
    @Expose

    private String hotel_image;



    public  CommonHotelModel(){


    }



    public CommonHotelModel(String hotel_id, String hotel_image, String name,String district) {
       // this.cluster_id = cluster_id;
       this.hotel_id = hotel_id;
        this.hotel_image =hotel_image;
        this.name=name;

        this.district=district;
        this.hotel_image=hotel_image;
        this.hotel_id = hotel_id;


    }


   /* public Integer getClusterId() {
        return cluster_id;
    }

    public void setClusterId(Integer cluster_id) {
        this.cluster_id = cluster_id;
    }*/

    public String getHotelId(){
        return hotel_id;
    }



    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }



    public String getName(){
        return name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getDistrict(){

        return district;
    }

    public void setDistrict(String district){
        this.district = district;
    }


    public String getHotel_Image(){

        return hotel_image;
    }

    public void setHotel_Image(String hotel_image){

        this.hotel_image = hotel_image;
    }









}
