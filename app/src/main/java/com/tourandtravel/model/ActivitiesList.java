package com.tourandtravel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by himanshu on 10-11-2017.
 */

public class ActivitiesList {


    @SerializedName("activity")
    private List<ActivitiesModel> activitiesModelList;
    @SerializedName("status")
    private int status;


    public ActivitiesList(List<ActivitiesModel> activitiesModelList, int status) {
        this.activitiesModelList= activitiesModelList;
        this.status = status;

    }

    public ActivitiesList() {
    }

    public  List<ActivitiesModel> getActivitiesModelList() {
        return activitiesModelList;
    }

    public void setActivitiesModelList(List<ActivitiesModel> activitiesModelList) {
        this.activitiesModelList = activitiesModelList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
