package com.example.pedalplates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
private Button bt1;
public EditText e1,e2,e3,e4;
DatabaseHelper mydb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        e1=(EditText)findViewById(R.id.et_name);
        e2=(EditText)findViewById(R.id.et_uname);
        e3=(EditText)findViewById(R.id.et_password);
        bt1=findViewById(R.id.button12);
        final DatabaseHelper mydb1 = new DatabaseHelper(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name=e1.getText().toString();
               String uname=e2.getText().toString();
               String Password=e3.getText().toString();

               if(name.length()!=0 && uname.length()!=0 && Password.length()!=0)
               {

                   boolean isInserted = mydb1.insertData(name,uname,Password);
                   Log.e("Karan",String.valueOf(isInserted));
                   if (isInserted) {
                       Toast.makeText(SignUp.this, "You Registered Successfully", Toast.LENGTH_LONG).show();
                       Intent i1 = new Intent(getApplicationContext(), Restaurants.class);
                       startActivity(i1);
                   }
                   else
                   {
                       Toast.makeText(SignUp.this, "Registration Un-Successfull", Toast.LENGTH_LONG).show();
                   }

               }
               else
               {
                   Toast.makeText(SignUp.this,"Enter all details",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}
