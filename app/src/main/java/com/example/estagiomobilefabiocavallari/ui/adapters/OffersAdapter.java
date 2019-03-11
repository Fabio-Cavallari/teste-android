package com.example.estagiomobilefabiocavallari.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estagiomobilefabiocavallari.R;
import com.example.estagiomobilefabiocavallari.model.Offer;
import com.example.estagiomobilefabiocavallari.presenter.HomePresenter;
import com.example.estagiomobilefabiocavallari.ui.listeners.OnOfferClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter {

    private Context context;
    private OnOfferClickListener onOfferClickListener;
    private HomePresenter presenter;

    public OffersAdapter(HomePresenter presenter,  Context context){
        this.presenter = presenter;
        this.context = context;
    }

    public void setOnOfferClickListener(OnOfferClickListener onOfferClickListener){
        this.onOfferClickListener = onOfferClickListener;
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
        presenter.BindOffer(holder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.offersList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class OffersViewHolder extends ViewHolder {

        private TextView title;
        private TextView value;
        private ImageView img;
        private Offer offer;

        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            value = itemView.findViewById(R.id.value);
            img = itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOfferClickListener.onOfferClick(offer);
                }
            });
        }

        public void setOffer(Offer offer) {
            this.offer = offer;
        }

        public void setTitle(String title) {
            this.title.setText(title);
        }

        public void setValue(String value) {
            this.value.setText("R$" + value);
        }

        public void setImg(String url) {
            Picasso.get()
                    .load(url)
                    .into(img);
        }

    }

}
