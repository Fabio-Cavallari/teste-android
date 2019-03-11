package com.example.estagiomobilefabiocavallari.presenter;

import android.os.Bundle;

import com.example.estagiomobilefabiocavallari.model.Offer;

public class DetailPresenter {

    private DetailView view;
    public Offer offer;

    public DetailPresenter(DetailView view) {
        this.view = view;
        this.offer = (Offer) view.getArguments().getSerializable("offer");
    }

    public void mountFragment(){
        view.setFoto(offer.getImage());
        view.setTitle(offer.getTitle());
        view.setDescription(offer.getDescription());
        view.setValue(offer.getValue());
    }

    public interface DetailView{
        Bundle getArguments();
        void setFoto(String url);
        void setTitle(String title);
        void setDescription(String description);
        void setValue(String value);
    }

}
