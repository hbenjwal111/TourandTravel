package com.tourandtravel.fragment;

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
import android.widget.TextView;
import android.widget.Toast;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;
import com.tourandtravel.adapter.HotelListAdapter;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;
import com.tourandtravel.model.CommonHotelModel;
import com.tourandtravel.model.HotelList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 01-11-2017.
 */

public class CommonHotelFragment  extends BaseFragment {


    private RecyclerView recyclerView;
    private List<HotelList> hotelLists;
    private HotelListAdapter mAdapter;
    private TextView chooseRoom;

    private APIService mAPIService;

    private   Integer cluster_id;

    private Integer hotel_id;



    String clus_id;


    private FragmentManager fragmentManager;

    public CommonHotelFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_common_hotel, parent, false);
         clus_id = getActivity().getIntent().getExtras().getString("clus_id");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);

        mAPIService = ApiUtils.getAPIService();

        setHasOptionsMenu(true);



       /* cartList = new ArrayList<>();*/






        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));




        recyclerView.addOnItemTouchListener(new ClusterFragment.RecyclerTouchListener(getActivity(), recyclerView, new ClusterFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

               Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.ROOM);
                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);





            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));

        getHotelList();

        return rootView;
    }

    private void getHotelList(){
        showProgressDialog();

        mAPIService.getHotelList(Integer.parseInt(clus_id)).enqueue(new Callback<HotelList>() {
            @Override
            public void onResponse(Call<HotelList> call, Response<HotelList> response) {

                HotelList hotelList = response.body();
                if(hotelList.getStatus()==1){
                    List<CommonHotelModel> listCluster = hotelList.getCommonHotelModelList();
                    HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(),listCluster);

                    recyclerView.setAdapter(hotelListAdapter);
                    dismissProgressDialog();
                }else{
                    dismissProgressDialog();
                }

            }

            @Override
            public void onFailure(Call<HotelList> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                dismissProgressDialog();


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
        private ClusterFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClusterFragment.ClickListener clickListener) {
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