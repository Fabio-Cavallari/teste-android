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
import com.example.estagiomobilefabiocavallari.presenter.DetailPresenter;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment implements DetailPresenter.DetailView {

    private DetailPresenter presenter;

    ImageView foto;
    TextView title;
    TextView description;
    TextView value;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new DetailPresenter(this);

        foto = view.findViewById(R.id.foto);
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        value = view.findViewById(R.id.value);

        presenter.mountFragment();
    }

    public void setFoto(String url){
        Picasso.get().load(url).into(this.foto);
    }
    public void setTitle(String title){
        this.title.setText(title);
    }
    public void setDescription(String description){
        this.description.setText(description);
    }
    public void setValue(String value){
        this.value.setText("R$"+value);
    }

}
