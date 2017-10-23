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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tourandtravel.R;
import com.tourandtravel.utils.LatLangBeans;

import java.util.ArrayList;
import java.util.HashMap;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.tourandtravel.R.id.map;

/**
 * Created by himanshu on 18-09-2017.
 */


public class MapFragment extends SupportMapFragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private ArrayList<LatLng> listLatLng;
    private RelativeLayout rlMapLayout;
    HashMap<Marker,LatLangBeans> hashMapMarker = new HashMap<Marker,LatLangBeans>();
    MapView mapView;

    GoogleApiClient mGoogleApiClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_map, null, false);
        EditText editText = (EditText)root.findViewById(R.id.fullNameEt);
       /* setData();*/

        initilizeMap();
        return root;
    }


    private void setData()
    {
        ArrayList<LatLangBeans> arrayList=new ArrayList<LatLangBeans>();
        LatLangBeans bean=new LatLangBeans();
        bean.setTitle("Ahmedabad");
        bean.setSnippet("Hello,Ahmedabad");
        bean.setLatitude("30.7344861");
        bean.setLongitude("79.0647465");
        arrayList.add(bean);

        LatLangBeans bean1=new LatLangBeans();
        bean1.setTitle("Surat");
        bean1.setSnippet("Hello,Surat");
        bean1.setLatitude("30.9951765");
        bean1.setLongitude("78.9364135");
        arrayList.add(bean1);

        LatLangBeans bean2=new LatLangBeans();
        bean2.setTitle("Vadodara");
        bean2.setSnippet("Hello,Vadodara");
        bean2.setLatitude("22.3000");
        bean2.setLongitude("73.2000");
        arrayList.add(bean2);

        LoadingGoogleMap(arrayList);
    }

    void LoadingGoogleMap(ArrayList<LatLangBeans> arrayList) {
        if (mMap != null) {
            mMap.clear();
            mMap.getUiSettings().setMyLocationButtonEnabled(true);

/* mMap.setMyLocationEnabled(true);*/

            mMap.getUiSettings().setZoomControlsEnabled(true);

            if (arrayList.size() > 0) {
                try {
                    listLatLng = new ArrayList<LatLng>();
                    for (int i = 0; i < arrayList.size(); i++) {
                        LatLangBeans bean = arrayList.get(i);
                        if (bean.getLatitude().length() > 0 && bean.getLongitude().length() > 0) {
                            double lat = Double.parseDouble(bean.getLatitude());
                            double lon = Double.parseDouble(bean.getLongitude());

                            Marker marker = mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(lat, lon))
                                    .title(bean.getTitle())
                                    .snippet(bean.getSnippet())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            //Add Marker to Hashmap
                            hashMapMarker.put(marker, bean);

                            //Set Zoom Level of Map pin
                            LatLng object = new LatLng(lat, lon);
                            listLatLng.add(object);
                        }
                    }
                    SetZoomlevel(listLatLng);


                    SetZoomlevel(listLatLng);


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }



    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

        @Override
        public void onInfoWindowClick(Marker position)
        {
            LatLangBeans bean=hashMapMarker.get(position);
            Toast.makeText(getApplicationContext(), bean.getTitle(),Toast.LENGTH_SHORT).show();

        }
    });
}
              }

                      else
                      {
                      Toast.makeText(getApplicationContext(),"Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
                      }
                      }

public void  SetZoomlevel(ArrayList<LatLng> listLatLng) {
    if (listLatLng != null && listLatLng.size() == 1) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(listLatLng.get(0), 10));
    } else if (listLatLng != null && listLatLng.size() > 1) {

        final LatLngBounds.Builder builder = LatLngBounds.builder();
        for (int i = 0; i < listLatLng.size(); i++) {
            builder.include(listLatLng.get(i));
        }

    }

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
           /* if (googleMap != null)
                googleMap.addMarker(new MarkerOptions().position(new LatLng(10.1253,10.5868)));*/
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

       /* mMap.addMarker(new MarkerOptions()
                .title("India")
                .snippet("New Delhi")
                .position(new LatLng(20.59, 78.96)));

        mMap.addMarker(new MarkerOptions()
                .title("Prague")
                .snippet("Czech Republic")
                .position(new LatLng(50.08, 14.43)));

        mMap.addMarker(new MarkerOptions()
                .title("Paris")
                .snippet("France")
                .position(new LatLng(48.86,2.33)));

        mMap.addMarker(new MarkerOptions()
                .title("London")
                .snippet("United Kingdom")
                .position(new LatLng(51.51,-0.1)));*/


    }





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

        //To clear map data
        mMap.clear();

        //To hold location
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //To create marker in map
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("My Location");
        //adding marker to the map
        mMap.addMarker(markerOptions);

        //opening position with some zoom level in the map
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));
    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}

