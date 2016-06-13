package com.example.llw.recyclerview_my.adapter.com;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.llw.recyclerview_my.MainActivity;
import com.example.llw.recyclerview_my.R;

/**
 * Created by llw on 2016/6/13.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> implements View.OnClickListener {
    public String[] data = null;
    public int[] images = null;
    public Context context = null;

    public OnRcyclerViewItemListener onRcyclerViewItemListener = null;

    public interface OnRcyclerViewItemListener {
        public void OnItemListener(View view);
    }

    public void Get_OnRcyclerViewItemListener(OnRcyclerViewItemListener onRcyclerViewItemListener) {
        this.onRcyclerViewItemListener = onRcyclerViewItemListener;
    }

    public Myadapter(MainActivity mainActivity, String[] data, int[] images) {
        this.context = mainActivity;
        this.data = data;
        this.images = images;
    }

    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(images[position]);
        holder.textView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    @Override
    public void onClick(View v) {
        if (onRcyclerViewItemListener != null) {
            onRcyclerViewItemListener.OnItemListener(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView = null;
        public ImageView imageView = null;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview_id);
            textView.setTextColor(Color.RED);
            imageView = (ImageView) itemView.findViewById(R.id.imageview_id);
        }
    }
}
