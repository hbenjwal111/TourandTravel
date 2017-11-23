package com.tourandtravel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 09-11-2017.
 */

public class LeisureTimeModel {

    @SerializedName("hotel_id")
    @Expose
    private Integer hotel_id;

    @SerializedName("name")
    @Expose
    private String hotel_name;

    @SerializedName("hotel_image")
    @Expose
    private String hotel_image;

    @SerializedName("prime_time_from")
    @Expose
    private String leisure_time_from;


    @SerializedName("prime_time_to")
    @Expose

    private String leisure_time_to;

    @SerializedName("type")
    @Expose

    private String type;

    @SerializedName("price")
    @Expose

    private String price;



    public  LeisureTimeModel(){


    }



    public LeisureTimeModel(int hotel_id, String leisure_time_from, String leisure_time_to,
                            String type,String price,
                            String hotel_image,String hotel_name ) {
        this.leisure_time_from= leisure_time_from;
        this.leisure_time_to=leisure_time_to;
        this.type= type;
        this.price=price;

        this.hotel_id = hotel_id;
        this.hotel_image=hotel_image;
        this.hotel_name = hotel_name;


    }

    public Integer getHotel_id(){
        return hotel_id;
    }
    public void setHotel_id(Integer hotel_id){
        this.hotel_id=hotel_id;
    }

    public String getLeisure_time_from(){
        return leisure_time_from;
    }
    public void setLeisure_time_from(String leisure_time_from){
        this.leisure_time_from = leisure_time_from;
    }

    public String getLeisure_time_to(){
        return leisure_time_to;
    }

    public void setLeisure_time_to(String leisure_time_to){
        this.leisure_time_to =leisure_time_to;
    }



    public String getHotel_name(){
        return hotel_name;
    }

    public void setHotel_name(String hotel_name){
        this.hotel_name =hotel_name;


    }

    public String getHotel_image(){
        return hotel_image;
    }

    public void setHotel_image(String hotel_image){
        this.hotel_image = hotel_image;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }



    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price=price;
    }









}
