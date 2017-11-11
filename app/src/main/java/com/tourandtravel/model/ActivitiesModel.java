package com.tourandtravel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 10-11-2017.
 */

public class ActivitiesModel {

    @SerializedName("activity_id")
    @Expose
    private Integer activity_id;

    @SerializedName("name")
    @Expose

    private String name;

    @SerializedName("about")
    @Expose

    private String about;

    @SerializedName("image")
    @Expose

    private String image;

    public  ActivitiesModel(){


    }

    public ActivitiesModel(int activity_id, String name, String about,String image) {
        this.activity_id = activity_id;
        this.name = name;
        this.about=about;
        this.image=image;

    }


    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getAbout(){

        return about;
    }

    public void setAbout(String about){
        this.about = about;
    }


    public String getImage(){

        return image;
    }

    public void setImage(String image){

        this.image = image;
    }


}
