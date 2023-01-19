package com.example.pedalplates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.google.android.material.chip.Chip;


public class ordering_menu extends AppCompatActivity implements View.OnClickListener {
    private CheckBox cb1, cb2;
            Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_menu);
        cb1= findViewById(R.id.checkBox);
        cb2= findViewById(R.id.checkBox3);
        b1= findViewById(R.id.button4);


        b1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button4 : Intent i=new Intent(ordering_menu.this,Order_Placed.class);
                startActivity(i);
                break;
            default:break;
        }

    }
}
