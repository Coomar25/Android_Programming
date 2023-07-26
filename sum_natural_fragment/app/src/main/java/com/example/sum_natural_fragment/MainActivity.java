package com.example.sum_natural_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate((R.menu.options.menu));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemid = item.getItemid();
        switch(itemid){
            case R.id.mail:
                Toast.makeText(this, "Mail Item", Toast.LENGTH_SHORT);
                return true;

            case R.id.share:
                Toast.makeText(this, "Share Item", Toast.LENGTH_LONG);
                return true;

            case R.id.upload:
                Toast.makeText(this, "Upload", Toast.LENGTH_SHORT);
                return true;
            case R.id.share1:
                Toast.makeText(this, "Sub menu Share 1", Toast.LENGTH_LONG);
                return true;

            default:
                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT);
                return super.onOptionsItemSelected(item);


        }

    }
}