package com.example.estagiomobilefabiocavallari.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.estagiomobilefabiocavallari.model.Offer;
import com.example.estagiomobilefabiocavallari.service.OfferService;
import com.example.estagiomobilefabiocavallari.ui.adapters.OffersAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePresenter {

    private HomeView view;
    public ArrayList<Offer> offersList;


    public HomePresenter(HomeView view) {
        this.view = view;
        offersList = new ArrayList<Offer>();
    }

    public void GetOffers() {
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
                view.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Offer>> call, Throwable t) {
                Toast.makeText(view.getContext(),"Erro durante a requisição", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void BindOffer(OffersAdapter.OffersViewHolder holder, int i){
        Offer offer = offersList.get(i);

        holder.setOffer(offer);
        holder.setTitle(offer.getTitle());
        holder.setValue(offer.getValue());
        holder.setImg(offer.getImage());
    }

    public interface HomeView{
        Context getContext();
        void notifyDataSetChanged();
    }
}
