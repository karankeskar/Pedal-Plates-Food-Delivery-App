package com.example.pedalplates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Paytm extends AppCompatActivity {
    private EditText et1,et2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);
        ActivityCompat.requestPermissions(Paytm.this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        et1=findViewById(R.id.editText2);
        et2=findViewById(R.id.editText3);
        b1=findViewById(R.id.button5);
    }
    public void sendSMS(View view){

        String message ="hey "+et1.getText().toString()+" Your otp from paytm is 6789";
        String number = et2.getText().toString();

        SmsManager mysmsmanager=SmsManager.getDefault();
        mysmsmanager.sendTextMessage(number,null,message,null,null);
        Intent intent = new Intent(Paytm.this,Order_Confirmed.class);
        startActivity(intent);

    }

}
