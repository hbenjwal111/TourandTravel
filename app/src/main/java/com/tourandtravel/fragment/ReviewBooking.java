package com.tourandtravel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;

/**
 * Created by himanshu on 01-11-2017.
 */

public class ReviewBooking extends BaseFragment {

    private TextView payButton;

    private TextView hotelName,checkIn,checkOut,numberRoom,numberPerson,roomCharge,roomType;

    private ImageView mImageView;

    String hotel_id,hotel_Name,hotel_image,checkInDate,checkOutDate,numRoom,numPerson,roomCharges,type;


    public ReviewBooking(){


    }



    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_review_booking, parent, false);

        hotel_id = getActivity().getIntent().getExtras().getString("hotel_id");

        hotel_Name = getActivity().getIntent().getExtras().getString("hotel_name");

        hotel_image = getActivity().getIntent().getExtras().getString("hotel_image");

        checkInDate = getActivity().getIntent().getExtras().getString("checkInDate");

        roomCharges =getActivity().getIntent().getExtras().getString("price");

        checkOutDate =getActivity().getIntent().getExtras().getString("checkOutDate");

        numRoom = getActivity().getIntent().getExtras().getString("numberRoom");

        numPerson = getActivity().getIntent().getExtras().getString("numberPerson");

        type = getActivity().getIntent().getExtras().getString("type");


        mImageView = (ImageView)rootView.findViewById(R.id.image);






        hotelName = (TextView)rootView.findViewById(R.id.tv_text);

            hotelName.setText(hotel_Name);

        checkIn = (TextView)rootView.findViewById(R.id.fromDtae);

          checkIn.setText(String.valueOf(checkInDate));

        checkOut = (TextView)rootView.findViewById(R.id.toDate);

          checkOut.setText(String.valueOf(checkOutDate));

        numberRoom = (TextView)rootView.findViewById(R.id.ruu);

          numberRoom.setText(String.valueOf(numRoom));

        numberPerson = (TextView)rootView.findViewById(R.id.ru);

          numberPerson.setText(String.valueOf(numPerson));

        roomCharge = (TextView)rootView.findViewById(R.id.gst);

          roomCharge.setText(roomCharges);

        roomType = (TextView)rootView.findViewById(R.id.check);

          roomType.setText(type);




        payButton = (TextView)rootView.findViewById(R.id.choose);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.TRAVELLER);
                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });
        return rootView;

    }
    @Override
    public void setTAG(String TAG) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }
}
