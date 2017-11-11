package com.tourandtravel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by himanshu on 09-11-2017.
 */

public class PrimeTimeList {


    @SerializedName("hotel_prime_prize")
    private List<PrimeTimeModel> primeTimeModels ;




    /*@SerializedName("hotel_id")
    @Expose
    private Integer hotel_id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("hotel_image")
    @Expose
    private String hotel_image;*/





    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;


    public PrimeTimeList(List<PrimeTimeModel> primeTimeModels, int status ,String message,String hotel_time,String hotel_prize/*,int hotel_id, String hotel_image, String name,String district*/) {
        this.primeTimeModels = primeTimeModels;
        this.status = status;
        this.message = message;

       /* this.hotel_id = hotel_id;
        this.hotel_image =hotel_image;
        this.name=name;
        this.district=district;*/

    }

    public PrimeTimeList() {
    }

    public  List<PrimeTimeModel> getPrimeTimeModels() {
        return primeTimeModels;
    }

    public void setPrimeTimeModels(List<PrimeTimeModel> primeTimeModels) {
        this.primeTimeModels = primeTimeModels;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(){
        this.message =message;
    }


   /* public Integer getHotel_id() {
        return hotel_id;
    }
    public void setHotel_id(Integer hotel_id) {
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
    public String getHotel_image(){
        return hotel_image;
    }
    public void setHotel_image(String hotel_image){
        this.hotel_image = hotel_image;
    }
*/


}
