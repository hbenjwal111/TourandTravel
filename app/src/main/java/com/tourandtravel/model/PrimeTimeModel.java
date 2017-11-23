package com.tourandtravel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 09-11-2017.
 */

public class PrimeTimeModel {

    @SerializedName("hotel_id")
    @Expose
    private Integer hotel_id;

    @SerializedName("name")
    @Expose
    private String hotel_name;

    @SerializedName("hotel_image")
    @Expose
    private String hotel_image;

    /*@SerializedName("hotel_time")
    @Expose
    private String hotel_time;

    @SerializedName("hotel_prize")
    @Expose
    private String hotel_prize;
*/
    @SerializedName("prime_time_from")
    @Expose
    private String prime_time_from;


    @SerializedName("prime_time_to")
    @Expose

    private String prime_time_to;

    @SerializedName("type")
    @Expose

    private String type;

    @SerializedName("price")
    @Expose

    private String price;


    public  PrimeTimeModel(){


    }



    public PrimeTimeModel(int hotel_id, String prime_time_from, String prime_time_to,
                         String type,String price,String hotel_image,String hotel_name) {
        this.prime_time_from= prime_time_from;
        this.prime_time_to=prime_time_to;
        this.type = type;
       this.price=price;

        this.hotel_image=hotel_image;
        this.hotel_name = hotel_name;

        this.hotel_id = hotel_id;



    }

    public Integer getHotel_id(){
        return hotel_id;
    }
    public void setHotel_id(Integer hotel_id){
        this.hotel_id=hotel_id;
    }

    public String getPrime_time_from(){
        return prime_time_from;
    }
    public void setPrime_time_from(String prime_time_from){
        this.prime_time_from = prime_time_from;
    }

    public String getPrime_time_to(){
        return prime_time_to;
    }

    public void setPrime_time_to(String prime_time_to){
        this.prime_time_to =prime_time_to;
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

      /* public String getHotel_time(){
           return hotel_time;
       }

       public void setHotel_time(String hotel_time){

           this.hotel_time = hotel_time;
       }

       public String getHotel_prize(){
           return hotel_prize;
       }

       public void setHotel_prize(String hotel_prize){

           this.hotel_prize = hotel_prize;
       }





*/








}

