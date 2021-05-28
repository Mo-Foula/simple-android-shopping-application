package com.example.mobile_section_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart_RecyclerViewAdapter extends RecyclerView.Adapter<Cart_RecyclerViewAdapter.MyViewHolder>  {
    Context context;
    Map<Integer, Integer> cart , temp_cart;
    Integer []array_keys;
    ArrayList<Item> items;

    void printCart(Map<Integer, Integer> cart) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAA");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    public Cart_RecyclerViewAdapter(Context c, Map<Integer,Integer> cart2 , ArrayList<Item> item) {
    context =c;
    this.cart=cart2;
    this.items= item;
    array_keys=  cart.keySet().toArray(new Integer[cart.size()]);

    }

    @NonNull
    @Override
    public Cart_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_recyclerviewrow, parent, false);
        return new Cart_RecyclerViewAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Cart_RecyclerViewAdapter.MyViewHolder holder, int position) {
        Integer item_id= array_keys[position];
        Integer quantity = cart.get(item_id);
        Item item = null;


        for (int i=0; i<items.size();i++){
            if(item_id.compareTo(items.get(i).getId())==0 ){
                item = items.get(i);
            }
        }
        if(item == null){
            return;
        }

        Log.d("A", "AAAAAAAAAAAAAAAAAAAAAA");
        holder.title.setText(item.getName());
        Log.d("A", "VVVVVVVVVVVV");

        holder.desc.setText(item.getDescription());
        Log.d("A", "QUANTITY     "+ quantity);

        holder.quantity.setText(quantity + " ");
        Log.d("A", "DDDDDDDDDDDDDDDDDD");

        holder.img.setImageResource(item.getImage());
        holder.price.setText(item.price+ " EGP");



    }

    @Override
    public int getItemCount() {
        return cart.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, price, quantity ;
        ImageView img;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_txt);
            desc = itemView.findViewById(R.id.desc_txt);
            img = itemView.findViewById(R.id.imgview);
            price = itemView.findViewById(R.id.price_txt);
            quantity = itemView.findViewById(R.id.quantity_txt);
        }
    }
}
