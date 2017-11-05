package com.tourandtravel.utils;

/**
 * Created by himanshu on 11-10-2017.
 */

public class ItemList{

    private int imageId;
    private String title;


        public ItemList(int imageId,String title) {
            this.imageId = imageId;
            this.title = title;

        }
        public int getImageId() {
            return imageId;
        }
        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}