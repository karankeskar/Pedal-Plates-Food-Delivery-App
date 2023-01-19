package com.example.pedalplates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Login extends AppCompatActivity {
private Button bt;
EditText e1,e2;
DatabaseHelper mydb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt=findViewById(R.id.button1);
        e1=findViewById(R.id.et_uname);
        e2=findViewById(R.id.et_password);
        final DatabaseHelper mydb1= new DatabaseHelper(getApplicationContext());
       // mydb1 = new DatabaseHelper(this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name=e1.getText().toString();
            String password=e2.getText().toString();

              if(name.length()!=0 && password.length()!=0)
              {
                  boolean isExist;

                  SQLiteDatabase db=mydb1.getReadableDatabase();
                  Cursor cursor=db.rawQuery("SELECT Name,Password FROM SignUp WHERE NAME=? AND PASSWORD=?",new String[]{e1.getText().toString(),e2.getText().toString()});
                  if(cursor.moveToNext()) {
                      isExist=true;

                  }
                  else {
                      isExist = false;
                  }

                  if(isExist)
                  {
                      Intent i1=new Intent(Login.this, Restaurants.class);
                      startActivity(i1);
                  }
                  else{
                      Toast.makeText(Login.this,"Your Not registered",Toast.LENGTH_LONG).show();
                  }


              }

            }
        });

    }
}
