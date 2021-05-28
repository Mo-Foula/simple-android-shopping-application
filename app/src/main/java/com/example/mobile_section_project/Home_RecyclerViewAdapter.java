package com.example.mobile_section_project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Home_RecyclerViewAdapter extends RecyclerView.Adapter<Home_RecyclerViewAdapter.MyViewHolder> {

    ArrayList<Item> items;

    public Map<Integer, Integer> cart;

    Context context;


    public Home_RecyclerViewAdapter(Context c, ArrayList<Item> item) {
        context = c;
        this.items = item;
        cart = new HashMap<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_recyclerviewrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.desc.setText(items.get(position).getDescription());

        //items[position]
        holder.img.setImageResource(items.get(position).getImage());
//        holder.title.setText(position+1+"");
        holder.title.setText(items.get(position).getName());
        holder.price.setText(items.get(position).getPrice() + " EGP");

        final int id = position+1;//lazm el items sorted by ID
        holder.quantity.setText(cart.containsKey(id) ? cart.get(id)+"" : "0");
//        final int id = items.get(position).getId();

        final MyViewHolder myholder = holder;

        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                System.out.println("key is "+id+"  position  "+position);
                int current = cart.containsKey(id) ? cart.get(id) : 0;
//                Log.d("awd", "adw");

                if (current >= 0 && current < 99) {
                    //position+1 current+1
                    cart.put(id, current + 1);
                    myholder.quantity.setText(current + 1 + "");
                } else
                    Toast.makeText(context, "Can't add more", Toast.LENGTH_SHORT).show();

//                printCart();
            }
        });



        holder.remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = cart.containsKey(id) ? cart.get(id) : 0; //cart.containsKey(position+1)==null?cart.get(position).second:0;
                if (current > 1) {
                    //position+1 current+1
                    cart.put(id , current - 1);
//                    cart.add(new Pair<Integer, Integer>(position+1,current-1));
                    myholder.quantity.setText(current - 1 + "");

                } else if (current == 1) {
                    cart.remove(id);
                    myholder.quantity.setText(current - 1 + "");
                } else
                    Toast.makeText(context, "Can't remove", Toast.LENGTH_SHORT).show();
//                printCart();
            }
        });
    }
    void printCart(){
        System.out.println("AAAAAAAAAAAAAAAAAAAAA");
        for (Map.Entry<Integer,Integer> entry : cart.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, price, quantity;
        ImageView img;
        Button add_btn, remove_btn;
        //double price;, ID

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_txt);
            desc = itemView.findViewById(R.id.desc_txt);
            img = itemView.findViewById(R.id.imgview);
            price = itemView.findViewById(R.id.price_txt);
            add_btn = itemView.findViewById(R.id.add_quantity_btn);
            remove_btn = itemView.findViewById(R.id.remove_quantity_btn);
            quantity = itemView.findViewById(R.id.quantity_txt);
        }
    }
}
