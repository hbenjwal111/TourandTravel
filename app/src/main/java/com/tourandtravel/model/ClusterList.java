package com.tourandtravel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by himanshu on 03-11-2017.
 */

public class ClusterList {

    @SerializedName("cluster")
    private List<ClusterModel> clusterModelList;
    @SerializedName("status")
    private int status;


    public ClusterList(List<ClusterModel> clusterModelList, int status) {
        this.clusterModelList = clusterModelList;
        this.status = status;

    }

    public ClusterList() {
    }

    public  List<ClusterModel> getClusterModelList() {
        return clusterModelList;
    }

    public void setClusterModelList(List<ClusterModel> clusterModelList) {
        this.clusterModelList = clusterModelList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
