package com.sarayut.testclickfocusrecyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anunda_USER on 3/9/2561.
 */

public class HorizontalVasItemAdapter extends RecyclerView.Adapter<HorizontalVasItemAdapter.ViewHolder> {

    private List<Vas> vasList;

    public HorizontalVasItemAdapter(List<Vas> vas) {
        this.vasList = vas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vas_item_column, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vas_price.setText(vasList.get(position).getPrice());
        holder.vas_promotion.setText(vasList.get(position).getPromotion());
        holder.vas_detail.setText(vasList.get(position).getPromotion_detail());
        holder.vas_detail2.setText(vasList.get(position).getPromotion_detail2());
    }

    @Override
    public int getItemCount() {
        return vasList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView vas_price;
        private TextView vas_promotion;
        private TextView vas_detail;
        private TextView vas_detail2;

        public ViewHolder(final View itemView) {
            super(itemView);
            this.vas_price = itemView.findViewById(R.id.id_vas_price);
            this.vas_promotion = itemView.findViewById(R.id.id_vas_promotion);
            this.vas_detail = itemView.findViewById(R.id.id_vas_detail);
            this.vas_detail2 = itemView.findViewById(R.id.id_vas_detail2);
        }
    }
}