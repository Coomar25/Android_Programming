package com.nischal.menuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,TestPopup.class);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid=item.getItemId();
        switch (itemid){
            case R.id.mail:
                Toast.makeText(this, "Mail Item", Toast.LENGTH_LONG).show();
                return true;
            case R.id.share:
                Toast.makeText(this, "Share item", Toast.LENGTH_LONG).show();
                return true;
            case R.id.upload:
                Toast.makeText(this, "Upload", Toast.LENGTH_LONG).show();
                return  true;
            case R.id.share1:
                Toast.makeText(this, "Second share", Toast.LENGTH_LONG).show();
            default:
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }

    }
}