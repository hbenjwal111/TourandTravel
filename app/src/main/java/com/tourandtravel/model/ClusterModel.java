package com.tourandtravel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 03-11-2017.
 */

public class ClusterModel {

    @SerializedName("cluster_id")
    @Expose
    private Integer cluster_id;

    @SerializedName("clus_title")
    @Expose

    private String clus_title;

    @SerializedName("clus_discription")
    @Expose

    private String clus_discription;

    @SerializedName("clus_image")
    @Expose

   private String clus_image;

   public  ClusterModel(){


    }

    public ClusterModel(int cluster_id, String clus_title, String clus_discription,String clus_image) {
        this.cluster_id = cluster_id;
        this.clus_title = clus_title;
        this.clus_discription=clus_discription;
        this.clus_image=clus_image;

    }


    public Integer getClusterId() {
        return cluster_id;
    }

    public void setClusterId(Integer cluster_id) {
        this.cluster_id = cluster_id;
    }

    public String getClusTitle(){
        return clus_title;
    }

    public void setClusTitle(String clus_title){

        this.clus_title = clus_title;
    }

    public String getClusDiscription(){

        return clus_discription;
    }

    public void setClusDiscription(String clus_Discription){
        this.clus_discription = clus_Discription;
    }


   public String getClusImage(){

       return clus_image;
   }

   public void setClusImage(String clus_image){

       this.clus_image = clus_image;
   }

}
