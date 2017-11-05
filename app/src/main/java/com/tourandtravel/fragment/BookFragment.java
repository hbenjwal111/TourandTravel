package com.tourandtravel.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
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



    private TextView fromDate, toDate;


    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;




    private Button mButton;

    String[] room = { "1","2","3","4","5","6","7","8"  };

    String[] people = {"1","2","3","4","5","6","7","8" };

    public BookFragment() {


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_book, parent, false);

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        Spinner spinner1 =(Spinner) rootView.findViewById(R.id.spinner1);

        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,room);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);

        ArrayAdapter aaa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,people);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner1.setAdapter(aaa);


        mButton =(Button)rootView.findViewById(R.id.button_previous);

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

