package com.example.pedalplates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Restaurants extends AppCompatActivity implements View.OnClickListener {
private CardView cv1,cv2,cv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        cv1= findViewById(R.id.cardv1);
        cv2= findViewById(R.id.cardv2);
        cv3= findViewById(R.id.cardv3);

        cv1.setOnClickListener(this);
        cv2.setOnClickListener(this);
        cv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
         case R.id.cardv1 : Intent i=new Intent(Restaurants.this,ordering_menu.class);
         startActivity(i);
             break;
         default:break;
     }

    }
}
