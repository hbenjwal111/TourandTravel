package com.tourandtravel.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;
import com.tourandtravel.adapter.TimeAdapter;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;
import com.tourandtravel.model.PrimeTimeList;
import com.tourandtravel.model.PrimeTimeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.Utils;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 01-11-2017.
 */

public class PrimeFragment  extends BaseFragment {


    private RecyclerView recyclerView;
    List<PrimeTimeModel> primeTimeModels;

    private TimeAdapter mAdapter;

    private APIService mAPIService;

    String hotel_id,hotel_name,hotel_image,price;



    private FragmentManager fragmentManager;

    private ProgressDialog progressDialog;

    public PrimeFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_prim, parent, false);

        hotel_id = getActivity().getIntent().getExtras().getString("hotel_id");

        hotel_name = getActivity().getIntent().getExtras().getString("hotel_name");

        price = getActivity().getIntent().getExtras().getString("price");

/*
        name = getActivity().getIntent().getExtras().getString("hotel_name");
*/





        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);


        setHasOptionsMenu(true);

        mAPIService = ApiUtils.getAPIService();

       /* cartList = new ArrayList<>();*/





        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));



        recyclerView.addOnItemTouchListener(new PrimeFragment.RecyclerTouchListener(getActivity(), recyclerView, new PrimeFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                PrimeTimeModel selectedItemPosition = primeTimeModels.get(position);



                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.BOOK);

                commonActivity.putExtra("hotel_name", selectedItemPosition.getHotel_name());
                commonActivity.putExtra("type", selectedItemPosition.getType());
                commonActivity.putExtra("hotel_image", selectedItemPosition.getHotel_image());
                commonActivity.putExtra("price",selectedItemPosition.getPrice());
                commonActivity.putExtra("hotel_id", selectedItemPosition.getHotel_id() + "");













                //  commonActivity.putExtra("name",name);





                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);





            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));

        getPriceList();

        return rootView;
    }


    private void getPriceList() {
        if (Utils.isNetworkConnected(getActivity(), true, R.style.AppCompatAlertDialogStyle)) {
            progressDialog = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mAPIService.getPriceList(Integer.parseInt(hotel_id)).enqueue(new Callback<PrimeTimeList>() {
            @Override
            public void onResponse(Call<PrimeTimeList> call, Response<PrimeTimeList> response) {

                PrimeTimeList commonList = response.body();
                if(commonList.getStatus()==1){
                   primeTimeModels = commonList.getPrimeTimeModels();
                    TimeAdapter commonAdapter = new TimeAdapter(getActivity(),primeTimeModels);

                    recyclerView.setAdapter(commonAdapter);
                    progressDialog.dismiss();
                }else{
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<PrimeTimeList> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();


            }
        });




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


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private PrimeFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final PrimeFragment.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
