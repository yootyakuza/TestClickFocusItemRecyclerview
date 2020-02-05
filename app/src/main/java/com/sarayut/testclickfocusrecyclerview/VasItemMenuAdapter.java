package com.sarayut.testclickfocusrecyclerview;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Anunda_USER on 3/9/2561.
 */

public class VasItemMenuAdapter extends RecyclerView.Adapter<VasItemMenuAdapter.ViewHolder> {

    private String[] _txt_menu;
    private int row_index = 0;
    protected  PositionMenuInterface _callback = null;

    public interface PositionMenuInterface{
        void getPositionMenu(int position);
    }

    public void  setCallback(PositionMenuInterface callback){
        this._callback = callback;
    }

    public VasItemMenuAdapter(String[] _txt_menu) {
        this._txt_menu = _txt_menu;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vas_item_menu, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item_menu.setText(_txt_menu[position]);
        holder.layout_item_menu.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged();
        });
        if(row_index == position){
            holder.layout_item_menu.setBackgroundColor(Color.parseColor("#f5a623"));
            holder.item_menu.setTextColor(Color.parseColor("#ffffff"));
            if(this._callback != null){
                this._callback.getPositionMenu(position);
            }
        }else {
            holder.layout_item_menu.setBackgroundColor(Color.parseColor("#f5f5f5"));
            holder.item_menu.setTextColor(Color.parseColor("#9b9b9b"));
        }
    }

    @Override
    public int getItemCount() {
        return _txt_menu.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView item_menu;
        private LinearLayout layout_item_menu;

        public ViewHolder(final View itemView) {
            super(itemView);
            this.item_menu = itemView.findViewById(R.id.td_text_item_menu);
            this.layout_item_menu = itemView.findViewById(R.id.id_layout_item_menu);
        }
    }
}