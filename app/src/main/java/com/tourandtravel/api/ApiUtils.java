package com.tourandtravel.api;

/**
 * Created by gagan.mathur on 9/4/2017.
 */
public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://maestrotravel.co.in/api/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
