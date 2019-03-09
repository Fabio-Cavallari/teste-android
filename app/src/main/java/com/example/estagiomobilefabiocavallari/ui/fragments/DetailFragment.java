package com.example.estagiomobilefabiocavallari.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estagiomobilefabiocavallari.R;
import com.example.estagiomobilefabiocavallari.model.Offer;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {

    private Offer offer;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        offer = (Offer) getArguments().getSerializable("offer");

        ImageView foto = view.findViewById(R.id.foto);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextView value = view.findViewById(R.id.value);
        Button button = view.findViewById(R.id.button);

        Picasso.get().load(offer.getImage()).into(foto);
        title.setText(offer.getTitle());
        description.setText(offer.getDescription());
        value.setText("R$"+offer.getValue());
    }

}
