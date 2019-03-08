package com.example.estagiomobilefabiocavallari.ui.Home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.estagiomobilefabiocavallari.R;
import com.example.estagiomobilefabiocavallari.model.Offer;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ArrayList<Offer> offersList;

    public HomeFragment() {
        // Required empty public constructor
        
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
        offersList.add(new Offer("lugar1", "url", 1000.00f));
        offersList.add(new Offer("lugar2", "url", 1000.00f));
        offersList.add(new Offer("lugar3", "url", 1000.00f));
        offersList.add(new Offer("lugar4", "url", 1000.00f));
        offersList.add(new Offer("lugar5", "url", 1000.00f));
        offersList.add(new Offer("lugar6", "url", 1000.00f));
        offersList.add(new Offer("lugar7", "url", 1000.00f));

        RecyclerView offersRecyler = view.findViewById(R.id.offers_list);
        offersRecyler.setAdapter(new OffersAdapter(offersList, getContext()));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        offersRecyler.setLayoutManager(layoutManager);
    }
}
