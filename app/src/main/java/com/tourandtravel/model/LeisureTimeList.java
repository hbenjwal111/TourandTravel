package com.tourandtravel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by himanshu on 09-11-2017.
 */

public class LeisureTimeList {

    @SerializedName("hotel_leisure_prize")
    private List<LeisureTimeModel> leisureTimeModelList ;

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


    public LeisureTimeList(List<LeisureTimeModel> leisureTimeModelList, int status ,String message/*,int hotel_id, String hotel_image, String name,String district*/) {
        this.leisureTimeModelList = leisureTimeModelList;
        this.status = status;
        this.message = message;
       /* this.hotel_id = hotel_id;
        this.hotel_image =hotel_image;
        this.name=name;
        this.district=district;*/

    }

    public LeisureTimeList() {
    }

    public  List<LeisureTimeModel> getLeisureTimeModelsList() {
        return leisureTimeModelList;
    }

    public void setLeisureTimeModelList(List<LeisureTimeModel> leisureTimeModelList) {
        this.leisureTimeModelList = leisureTimeModelList;
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
