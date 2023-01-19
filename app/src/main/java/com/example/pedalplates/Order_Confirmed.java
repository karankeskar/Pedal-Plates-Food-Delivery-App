package com.example.pedalplates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Order_Confirmed extends AppCompatActivity {
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__confirmed);
        b1 = findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f =  new Intent();
                String ph="8310872986";
                ActivityCompat.requestPermissions(Order_Confirmed.this,new String[] {Manifest.permission.CALL_PHONE},1);
                f.setAction(Intent.ACTION_CALL);
                f.setData(Uri.parse("tel:"+ph));
                startActivity(f);

            }
        });
    }
}


