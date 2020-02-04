package com.sarayut.testclickfocusrecyclerview;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private String[] txt_menu;
    int row_index = 0;
    protected  PositionMenuInterface _callback = null;

    public interface PositionMenuInterface{
        void getPositionMenu(int position);
    }

    public void  setCallback(PositionMenuInterface callback){
        this._callback = callback;
    }

    public TestAdapter(String[] txt_menu) {
        this.txt_menu = txt_menu;
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_detail,viewGroup,false);
        return new TestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(txt_menu[position]);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            holder.linearLayout.setBackgroundColor(Color.parseColor("#f5a623"));
            holder.textView.setTextColor(Color.parseColor("#ffffff"));
            if(this._callback != null){
                this._callback.getPositionMenu(position);
            }
        }
        else
        {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#f5f5f5"));
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return txt_menu.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.id_text);
            this.linearLayout = itemView.findViewById(R.id.id_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mItemClickListener != null){
                mItemClickListener.onItemClickListener(v,getAdapterPosition());
            }
        }
    }
    private onRecyclerViewItemClickListener mItemClickListener;

    public void setOnItemClickListener(onRecyclerViewItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface onRecyclerViewItemClickListener {
        void onItemClickListener(View view, int position);
    }
}