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

    @SerializedName("ac")
    @Expose

    private float ac;

    @SerializedName("sup_dlx")
    @Expose

    private float sup_dlx;

    @SerializedName("dlx")
    @Expose

    private String dlx;

    @SerializedName("fam_sup_dlx")
    @Expose

    private float fam_sup_dlx;

    @SerializedName("sm_dlx")
    @Expose

    private float sm_dlx;

    @SerializedName("eco")
    @Expose

    private float eco;

    @SerializedName("ord")
    @Expose

    private float ord;

    @SerializedName("tent_dorm")
    @Expose

    private float tent_dorm;

    @SerializedName("dlx_room")
    @Expose

    private float dlx_room;



    public  PrimeTimeModel(){


    }



    public PrimeTimeModel(int hotel_id, String prime_time_from, String prime_time_to,
                         float ac,float sm_dlx,float sup_dlx,float fam_sup_dlx,float eco,
                          float ord,float tent_dorm,float dlx_room,String dlx,String hotel_image,String hotel_name,String
                          hotel_time,String hotel_prize) {
        this.prime_time_from= prime_time_from;
        this.prime_time_to=prime_time_to;
        this.ac=ac;
        this.dlx=dlx;
        this.dlx_room=dlx_room;
        this.fam_sup_dlx=fam_sup_dlx;
        this.eco=eco;
        this.sm_dlx=sm_dlx;
        this.sup_dlx=sup_dlx;
        this.hotel_image=hotel_image;
        this.hotel_name = hotel_name;
        this.ord=ord;
        this.tent_dorm=tent_dorm;
        this.hotel_id = hotel_id;
        /*this.hotel_time = hotel_time;
        this.hotel_prize = hotel_prize;*/


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

    public float getAc(){
        return ac;
    }
    public void setAc(float ac){
        this.ac = ac;
    }
    public String getDlx(){
        return dlx;
    }

    public void setDlx(String dlx){
        this.dlx = dlx;
    }
    public float getDlx_room(){
        return dlx_room;
    }

    public void setDlx_room(float dlx_room){
        this.dlx_room=dlx_room;
    }
    public float getFam_sup_dlx(){
        return fam_sup_dlx;
    }
    public void setFam_sup_dlx(float fam_sup_dlx){
        this.fam_sup_dlx=fam_sup_dlx;

    }
    public float getEco(){
        return eco;
    }

    public void setEco(float eco){
        this.eco=eco;
    }
    public float getSm_dlx(){
        return sm_dlx;
    }

    public void setSm_dlx(float sm_dlx){
        this.sm_dlx=sm_dlx;

    }
    public float getSup_dlx(){
        return sup_dlx;
    }
    public void setSup_dlx(float sup_dlx){
        this.sup_dlx=sup_dlx;
    }

    public float getOrd(){
        return ord;
    }

    public void setOrd(float ord){

        this.ord=ord;
    }

    public float getTent_dorm(){
        return tent_dorm;
    }

    public void setTent_dorm(float tent_dorm){
        this.tent_dorm=tent_dorm;

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

