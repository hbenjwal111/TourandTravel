package com.tourandtravel.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.tourandtravel.R;

/**
 * Created by himanshu on 18-09-2017.
 */


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_map, parent, false);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapView = (MapView) rootView.findViewById(R.id.mapView);
        mapView.getMapAsync(this);

        return rootView;
    }


     public boolean googleServiceAvailable(){

         GoogleApiAvailability api = GoogleApiAvailability.getInstance();
         int isAvailable = api.isGooglePlayServicesAvailable(getActivity());
         if(isAvailable == ConnectionResult.SUCCESS){

             return true;
         }else if(api.isUserResolvableError(isAvailable)){

             Dialog dialog = api.getErrorDialog(getActivity(),isAvailable,0);
         }else{

             Toast.makeText(getActivity(),"no",Toast.LENGTH_LONG).show();
         }
         return false;


     }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

     /*   // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
}

