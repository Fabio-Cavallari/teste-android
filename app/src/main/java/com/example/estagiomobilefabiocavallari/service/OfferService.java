package com.example.estagiomobilefabiocavallari.service;

import com.example.estagiomobilefabiocavallari.model.Offer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OfferService {

    String BASE_URL = "https://private-867136-viajabessaapi4.apiary-mock.com/";

    @GET("offers")
    Call<List<Offer>> getOffers();
}
