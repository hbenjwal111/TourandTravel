package com.tourandtravel.utils;

/**
 * Created by himanshu on 01-11-2017.
 */

public class room {


    private int imageId;
    private String time;
    private String title;
    private String type;
    private String price;

    public room(int imageId, String title,String time,String type, String price ) {
        this.imageId = imageId;
        this.title = title;
        this.time =time;
        this.type =type;
        this.price=price;

    }



    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}

