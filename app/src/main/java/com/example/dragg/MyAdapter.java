package com.example.dragg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    Context context;
    List<Item> itemns;

    public MyAdapter(Context context, List<Item> itemns) {
        this.context = context;
        this.itemns = itemns;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.nameView.setText(itemns.get(position).getName());
    holder.imageView.setImageResource(itemns.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemns.size();
    }
}
