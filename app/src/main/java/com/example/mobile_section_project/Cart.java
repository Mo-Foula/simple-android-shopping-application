package com.example.mobile_section_project;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Map;

public class Cart extends AppCompatActivity {
Button btNotification;
Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        SharedPreferences sp = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        String details = sp.getString("display", "Email or password incorrect");
        String user_name = details;
        View layout = findViewById(R.id.included_layout);
        ImageView logo = layout.findViewById(R.id.logo);
        logo.setImageResource(R.drawable.zftt);
        ImageView shopiMe = layout.findViewById(R.id.shopiMe);
        shopiMe.setImageResource(R.drawable.logoname);
        TextView welcomeText = layout.findViewById(R.id.welcome_text);
        welcomeText.setText("Welcome, "+user_name);

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
        items.add(new Item(12,R.drawable.footwear11,"Dolce & Gabbana","logo print slip-on trainers", 25));



        Intent it = getIntent();
        final Map<Integer, Integer> cart = (Map<Integer, Integer>) it.getSerializableExtra("ItemsInCart");
        RecyclerView RV = findViewById(R.id.recyclerview);
        TextView total_price= findViewById(R.id.total_price);
        final Cart_RecyclerViewAdapter cartRecyclerViewAdapter = new Cart_RecyclerViewAdapter(this, cart, items);
        final double total = calcPrice(cart,items);
        total_price.setText("Total Price: "+total+" EGP");

        RV.setAdapter(cartRecyclerViewAdapter);
        RV.setLayoutManager(new LinearLayoutManager(this));

        share = (Button)findViewById(R.id.share);
        final String itemssss = cart.size()>1?"items":"item";
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody= "Hello, I have ordered "+cart.size() +" "+itemssss +" from ShopiMe application for only " +total +" EGP";
                String shareSub = "Your subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share using"));


            }
        });



        btNotification = findViewById(R.id.notifi);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String message = "Order Has Been Confirmed *_* \n Your Total Price:" + total;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Cart.this,"My Notification");
                                builder.setContentTitle("Confirmation Massage");
                                builder.setContentText(message);
                                builder.setSmallIcon(R.drawable.ic_message);

                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Cart.this);

                managerCompat.notify(1,builder.build());




                //                Intent intent = new Intent(Cart.this,NotificationActivity.class);
//
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.putExtra("message",message);
//                PendingIntent pendingIntent = PendingIntent.getActivity(Cart.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(pendingIntent);
//                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//                notificationManager.notify(0,builder.build());

            }
        });

    }

    double calcPrice(Map<Integer, Integer> cart,ArrayList<Item> items){
        double x=0;
        for (Map.Entry<Integer, Integer> entry : cart.entrySet())
            for( int i=0 ; i< items.size();i++ ){
                if(entry.getKey() == items.get(i).getId()) {
                    //momkn error
                    x += entry.getValue()* items.get(i).getPrice();
                    break;
                }
            }
        return x;

    }

    void printCart(Map<Integer, Integer> cart) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAA");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}