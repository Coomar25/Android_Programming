package com.example.alert;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.Cleaner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.button);
        Button cal = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCustomDialog();
            }
        });

    }
    public void opendialog(){
        AlertDialog.Builder alertDailog=new AlertDialog.Builder(this);
        alertDailog.setTitle("Conform exit.....");
        alertDailog.setMessage("are tyou sure, you want to exit....");
        alertDailog.setCancelable(false);
        alertDailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDailog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You clicked over No!!", Toast.LENGTH_SHORT).show();
            }
        });
        alertDailog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You clicked on Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialoghere=alertDailog.create();
        alertDialoghere.show();
    }


    public void openCustomDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("SIMPLE INTEREST CALCULATOR");
        builder.setCancelable(true);
        View v=getLayoutInflater().inflate(R.layout.silayout, null);
        builder.setView(v);
        EditText principal = v.findViewById(R.id.principal);
        EditText rate = v.findViewById(R.id.rate);
        EditText time = v.findViewById(R.id.time);
        TextView re = v.findViewById(R.id.result);
        Button cal = v.findViewById(R.id.calculate);
        Toast.makeText(MainActivity.this, "Principal", Toast.LENGTH_SHORT).show();
        cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int p=Integer.parseInt(principal.getText().toString());
                int r =Integer.parseInt((rate.getText().toString()));
                int t= Integer.parseInt((time.getText().toString()));
                int si = (p*t*r)/100;
                re.setText("SI is "+ si);
            }
        });



        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You clicked over No!!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You clicked on Cancel", Toast.LENGTH_SHORT).show();
            }
        });

            builder.create().show();

    }
}