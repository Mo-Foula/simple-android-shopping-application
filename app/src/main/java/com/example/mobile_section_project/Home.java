package com.example.mobile_section_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        final ArrayList<Item> items = new ArrayList<Item>();

        //Item(int id, int image, String name, String description)
        items.add(new Item(1,R.drawable.footwear1,"Jordan Gray White Red","Air Jordan 1 Retro High sneakers", 30));

        items.add(new Item(2,R.drawable.footwear2,"Jordan White Black","Air Jordan 7 Retro \"Flint\" sneakers", 32.3));
        items.add(new Item(3,R.drawable.footwear3,"Raf Simons","Cylon-21 low-top sneakers", 28));
        items.add(new Item(4,R.drawable.footwear4,"Jordan Red","Air Jordan 13 Retro sneakers", 25));
        items.add(new Item(5,R.drawable.footwear5,"Jordan White Baby Blue","Air Jordan 1 Retro High sneakers", 25));
        items.add(new Item(6,R.drawable.footwear6,"Off-White","Vulcanized Fiag low-top sneakers", 25));
        items.add(new Item(7,R.drawable.footwear7,"Palm Angels","Vulcanized touch-strap snakers", 25));
        items.add(new Item(8,R.drawable.footwear8,"Dsquared2","Bubble low-top sneakers", 25));
        items.add(new Item(9,R.drawable.footwear9,"Maison Margiela x Reebok","Tabi Instapump chunky sneakers", 25));
        items.add(new Item(10,R.drawable.footwear10,"Dsquared2","551 lace-up sneakers", 25));
        items.add(new Item(11,R.drawable.footwear11,"Dolce & Gabbana","logo print slip-on trainers", 25));


        RecyclerView RV = findViewById(R.id.recyclerview);

        final Home_RecyclerViewAdapter homeRecyclerViewAdapter = new Home_RecyclerViewAdapter(this, items);

        RV.setAdapter(homeRecyclerViewAdapter);
        RV.setLayoutManager(new LinearLayoutManager(this));

        Button gotocart = findViewById(R.id.go_to_cart);

//        Button gotocart = findViewById(R.id.Notifi);
        gotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Cart.class);
                it.putExtra("ItemsInCart", (Serializable) homeRecyclerViewAdapter.cart);
                startActivity(it);
            }
        });

    }
}