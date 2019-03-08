package com.example.estagiomobilefabiocavallari.ui.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estagiomobilefabiocavallari.R;
import com.example.estagiomobilefabiocavallari.model.Offer;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter {
    private ArrayList<Offer> offers;
    private Context context;

    public OffersAdapter(ArrayList<Offer> offers, Context context){
        this.offers = offers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.fragment_home_item, viewGroup, false);
        OffersViewHolder holder = new OffersViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        OffersViewHolder holder =  (OffersViewHolder) viewHolder;
        Offer offer = offers.get(i);

        holder.title.setText(offer.getTitle());
        holder.value.setText(Float.toString(offer.getValue()));
        holder.img.setText(offer.getImage());

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}

class OffersViewHolder extends ViewHolder {
    final TextView title;
    final TextView value;
    final TextView img;

    public OffersViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        value = itemView.findViewById(R.id.img);
        img = itemView.findViewById(R.id.value);
    }
}
