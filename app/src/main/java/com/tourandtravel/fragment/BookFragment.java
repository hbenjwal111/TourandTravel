package com.tourandtravel.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by himanshu on 24-10-2017.
 */

public class BookFragment extends BaseFragment implements View.OnClickListener {



    private TextView fromDate, toDate,display,pdisplay;


    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    String hotel_id;

    SharedPreferences pref;


    String checkInDate,checkOutDate,numberRoom,numberPerson;




    private Button mButton;



    private Button add,sub,padd,psub;

   int  numtest = 1;




    public BookFragment() {


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_book, parent, false);

        hotel_id = getActivity().getIntent().getExtras().getString("hotel_id");







        mButton =(Button)rootView.findViewById(R.id.button_previous);

      add = (Button)rootView.findViewById(R.id.increase);
      sub = (Button)rootView.findViewById(R.id.decrease);

        padd = (Button)rootView.findViewById(R.id.Pincrease);
        psub = (Button)rootView.findViewById(R.id.Pdecrease);

        display = (TextView)rootView.findViewById(R.id.integer_number);
        pdisplay = (TextView)rootView.findViewById(R.id.Pinteger_number);

        int i = Integer.valueOf(display.getText().toString());

        int j = Integer.valueOf(pdisplay.getText().toString());






         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 numtest = numtest + 1;
                 display.setText("" + numtest);

             }
         });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (numtest < 1){
                    numtest =  1;
                    display.setText(numtest+ "");
                }
                if (numtest > 1) {
                    numtest = numtest - 1;
                    display.setText(numtest+ "");
                }
            }
        });


        padd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numtest = numtest + 1;
                pdisplay.setText("" + numtest);

            }
        });

        psub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (numtest < 1){
                    numtest =  1;
                    pdisplay.setText(numtest+ "");
                }
                if (numtest > 1) {
                    numtest = numtest - 1;
                    pdisplay.setText(numtest+ "");
                }
            }
        });



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.REVIEW);

                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });





        fromDate = (TextView) rootView.findViewById(R.id.fromDtae);
        fromDate.setOnClickListener(this);
        toDate = (TextView) rootView.findViewById(R.id.toDate);
        toDate.setOnClickListener(this);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        setHasOptionsMenu(true);
        setDateTimeField();




        return rootView;


    }

    @Override
    public void setTAG(String TAG) {

    }

    private void setDateTimeField() {
        fromDate.setOnClickListener(this);
        toDate.setOnClickListener(this);

        final Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {


            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();

                newDate.set(year, monthOfYear, dayOfMonth);




                fromDate.setText(dateFormatter.format(newDate.getTime()));


            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        fromDatePickerDialog.getDatePicker().setMinDate(newCalendar.getTimeInMillis());
        fromDatePickerDialog.setTitle("Checkin Date");


        toDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDate.setText(dateFormatter.format(newDate.getTime()));


            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        toDatePickerDialog.getDatePicker().setMinDate(newCalendar.getTimeInMillis());
        toDatePickerDialog.setTitle("Checkout Date");



    }



    @Override
    public void onClick(View view) {
        if(view == fromDate) {
            fromDatePickerDialog.show();
        } else if(view == toDate) {


            toDatePickerDialog.show();
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }
}

