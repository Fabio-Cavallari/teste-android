package com.example.estagiomobilefabiocavallari.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.estagiomobilefabiocavallari.R;
import com.example.estagiomobilefabiocavallari.model.Offer;
import com.example.estagiomobilefabiocavallari.service.OfferService;
import com.example.estagiomobilefabiocavallari.ui.adapters.OffersAdapter;
import com.example.estagiomobilefabiocavallari.ui.listeners.OnOfferClickListener;
import com.example.estagiomobilefabiocavallari.ui.activities.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    ArrayList<Offer> offersList;
    OffersAdapter offersAdapter;

    public HomeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        offersList = new ArrayList<Offer>();

        RecyclerView offersRecyler = view.findViewById(R.id.offers_list);
        offersAdapter = new OffersAdapter(offersList, getContext());
        offersRecyler.setAdapter(offersAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        offersRecyler.setLayoutManager(layoutManager);
        offersAdapter.setOnOfferClickListener(new OnOfferClickListener() {
            @Override
            public void onOfferClick(Offer offer) {
                HomeActivity homeActivity = (HomeActivity) getActivity();
                homeActivity.NavigateToDetail(offer);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        GetOffers();
    }

    private void GetOffers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OfferService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OfferService api = retrofit.create(OfferService.class);

        Call<List<Offer>> call = api.getOffers();
        call.enqueue(new Callback<List<Offer>>() {
            @Override
            public void onResponse(Call<List<Offer>> call, Response<List<Offer>> response) {
                List<Offer> offers = response.body();
                for (Offer offer :
                        offers) {
                    offersList.add(offer);
                }
                offersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Offer>> call, Throwable t) {
                Toast.makeText(getContext(),"Erro durante a requisição", Toast.LENGTH_LONG).show();
            }
        });
    }
}
