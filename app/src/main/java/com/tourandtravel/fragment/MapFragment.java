
package com.tourandtravel.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tourandtravel.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.tourandtravel.R.id.map;

/**
 * Created by himanshu on 18-09-2017.
 */



public class MapFragment extends SupportMapFragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;

    private RelativeLayout rlMapLayout;

    // Google Map

    private GoogleMap googleMap;
    private Double Latitude = 0.00;
    private Double Longitude = 0.00;


    MapView mapView;

    GoogleApiClient mGoogleApiClient;





    MapFragment mapFragment;
    GoogleMap gMap;
    MarkerOptions markerOptions = new MarkerOptions();
    CameraPosition cameraPosition;
    LatLng  latLng;


    public static final String ID = "cluster_id";

    public static final String LAT = "clus_location_lat";
    public static final String LNG = "clus_location_lon";

    private String url = "http://maestrotravel.co.in/api/maestrotravel_cluster_location.php";

    String tag_json_obj = "cluster_location";





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_map, null, false);



        initilizeMap();




        return root;
    }

    private void initilizeMap() {
        SupportMapFragment mSupportMapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(map);
        if (mSupportMapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mSupportMapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(map, mSupportMapFragment).commit();
        }
        if (mSupportMapFragment != null) {
            mSupportMapFragment.getMapAsync(this);


        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mGoogleApiClient.connect();


        getMarkers();



    }




    private void addMarker(LatLng location) {
        mMap.clear();

        //To hold location

        //To create marker in map
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        //adding marker to the map
        mMap.addMarker(markerOptions);

        //opening position with some zoom level in the map
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));



    }

    private void getMarkers() {
        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e("Response: ", response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    String getObject = jObj.getString("cluster_location");
                    JSONArray jsonArray = new JSONArray(getObject);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        latLng = new LatLng(Double.parseDouble(jsonObject.getString(LAT)), Double.parseDouble(jsonObject.getString(LNG)));

                        // Menambah data marker untuk di tampilkan ke google map
                        addMarker(latLng);
                    }

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error: ", error.getMessage());
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(getActivity()).add(strReq);    }





    LocationRequest mLocationRequest;

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000000);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }


 @Override
    public void onLocationChanged(Location location) {

     /*   //To clear map data
        mMap.clear();

        //To hold location
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //To create marker in map
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        //adding marker to the map
        mMap.addMarker(markerOptions);

        //opening position with some zoom level in the map
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));

        mMap.addMarker(new MarkerOptions()
                .title("Gangotri")
                .position(new LatLng(30.9951765,78.9364135)));
        mMap.addMarker(new MarkerOptions()
                .title("Badrinath")
                .position(new LatLng(30.7417522,79.4852149)));
        mMap.addMarker(new MarkerOptions()
                .title("kausani")
                .position(new LatLng(29.8430212,79.5956414)));
        mMap.addMarker(new MarkerOptions()
                .title("Chakrata")
                .position(new LatLng(30.7033198,77.857983)));
        mMap.addMarker(new MarkerOptions()
                .title("yamunotri")
                .position(new LatLng(31.0127489,78.4506513)));
        mMap.addMarker(new MarkerOptions()
                .title("Uttarkashi")
                .position(new LatLng(30.7249938,78.4114192)));
        mMap.addMarker(new MarkerOptions()
                .title("Kedarnath")
                .position(new LatLng(30.7344861,79.0647465)));
        mMap.addMarker(new MarkerOptions()
                .title("Dhanaulti")
                .position(new LatLng(30.4043058,78.2158204)));
        mMap.addMarker(new MarkerOptions()
                .title("Haridwar")
                .position(new LatLng(29.9527801,78.045885)));
        mMap.addMarker(new MarkerOptions()
                .title("Tehri")
                .position(new LatLng(30.3787326,78.4286888)));
        mMap.addMarker(new MarkerOptions()
                .title("Dehradun")
                .position(new LatLng(30.325558,77.9470939)));
        mMap.addMarker(new MarkerOptions()
                .title("Hemkund Shahib")
                .position(new LatLng(30.3234499,78.2736445)));
        mMap.addMarker(new MarkerOptions()
                .title("Rudraprayag")
                .position(new LatLng(30.2854095,78.9709604)));
        mMap.addMarker(new MarkerOptions()
                .title("Lansdown")
                .position(new LatLng(29.8433511,78.6711537)));

*/
    }




    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }






}


