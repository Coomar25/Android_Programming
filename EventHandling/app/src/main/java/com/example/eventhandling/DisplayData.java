package com.example.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {

    TextView Uname, Name, Email, Gender, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);



        //        Paila ko activity bata data tanera variable ma store gareee
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String uname = i.getStringExtra("uname");
        String email = i.getStringExtra("email");
        String gender = i.getStringExtra("gender");
        String password = i.getStringExtra("password");

        // textview lai target garne id bata

         Uname = findViewById(R.id.textViewUname);
         Name = findViewById(R.id.textViewName);
         Email = findViewById(R.id.textViewEmail);
         Gender = findViewById(R.id.textViewGender);
         Password = findViewById(R.id.password);


//        ava display garne UI ma
        Name.setText( name);
        Uname.setText(uname);
        Email.setText( email);
        Gender.setText(gender);
        Password.setText(password);




    }
}