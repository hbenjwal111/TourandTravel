package com.tourandtravel.utils;

/**
 * Created by himanshu on 29-10-2017.
 */

public class Custers {

    private int imageId;
    private String desc;

    public Custers(int imageId,  String desc) {
        this.imageId = imageId;

        this.desc = desc;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }


}
