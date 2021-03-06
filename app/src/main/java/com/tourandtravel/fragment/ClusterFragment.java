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
import com.tourandtravel.adapter.ClusterAdapter;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;
import com.tourandtravel.model.ClusterList;
import com.tourandtravel.model.ClusterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.Utils;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 18-09-2017.
 */

public class ClusterFragment extends BaseFragment {


    List<ClusterModel> listCluster;

    private RecyclerView recyclerView;
    private ClusterAdapter mAdapter;
    private APIService mAPIService;


    private FragmentManager fragmentManager;


    private  Integer cluster_id;
    private   String clus_discription;
    private String clus_image;
    private  String clus_title;

    private ProgressDialog progressDialog;



    public ClusterFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_cluster, parent, false);



        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);

        mAPIService = ApiUtils.getAPIService();




        setHasOptionsMenu(true);








        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));




        recyclerView.addOnItemTouchListener(new ClusterFragment.RecyclerTouchListener(getActivity(), recyclerView, new ClusterFragment.ClickListener() {



            @Override
            public void onClick(View view, int position) {



                ClusterModel selectedItemData = listCluster.get(position);




                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.CHECK_IN_NAV);
                commonActivity.putExtra("clus_description", selectedItemData.getClusDiscription());
                commonActivity.putExtra("clus_image", selectedItemData.getClusImage());
                commonActivity.putExtra("clus_title", selectedItemData.getClusTitle());

                commonActivity.putExtra("clus_id", selectedItemData.getClusterId()+"");

                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);





            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);





        getAllCluster();





        return rootView;





    }


    private void getAllCluster(){

        if (Utils.isNetworkConnected(getActivity(), true, R.style.AppCompatAlertDialogStyle)) {
            progressDialog = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mAPIService.getAllCluster(clus_title,clus_discription,clus_image).enqueue(new Callback<ClusterList>() {
            @Override
            public void onResponse(Call<ClusterList> call, Response<ClusterList> response) {





                ClusterList listClusterModel = response.body();
                if(listClusterModel.getStatus()==1){

                    listCluster = listClusterModel.getClusterModelList();
                    ClusterAdapter clusterAdapter = new ClusterAdapter(getActivity(),listCluster);

                    recyclerView.setAdapter(clusterAdapter);

                    progressDialog.dismiss();

                }else{
                   /* progressDialog.dismiss();*/
                }

            }

            @Override
            public void onFailure(Call<ClusterList> call, Throwable t) {

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
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));



                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());

            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));

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