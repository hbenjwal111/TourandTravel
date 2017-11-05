package com.tourandtravel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 05-11-2017.
 */

public class CommonModel {


    @SerializedName("cluster_id")
    @Expose
    private Integer cluster_id;

   /* @SerializedName("clus_title")
    @Expose

    private String clus_title;

    @SerializedName("clus_about")
    @Expose

    private String clus_about;

    @SerializedName("clus_image")
    @Expose

    private String clus_image;
*/


    public  CommonModel(){


    }

    public CommonModel(int cluster_id/*, String clus_title, String clus_about,String clus_image*/) {
        this.cluster_id = cluster_id;
       /* this.clus_title =clus_title;
        this.clus_about=clus_about;
        this.clus_image=clus_image;*/


    }


    public Integer getClusterId() {
        return cluster_id;
    }

    public void setClusterId(Integer cluster_id) {
        this.cluster_id = cluster_id;
    }

  /*  public String getClusTitle(){
        return clus_title;
    }

    public void setClusTitle(String clus_title){

        this.clus_title = clus_title;
    }

    public String getClus_about(){

        return clus_about;
    }

    public void setClus_about(String clus_about){
        this.clus_about = clus_about;
    }


    public String getClusImage(){

        return clus_image;
    }

    public void setClusImage(String clus_image){

        this.clus_image = clus_image;
    }

*/







}
