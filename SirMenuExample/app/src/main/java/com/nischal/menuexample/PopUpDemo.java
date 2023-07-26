package com.nischal.menuexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class PopUpDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_demo);
        Button btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu= new PopupMenu(PopUpDemo.this,btn);
                menu.getMenuInflater().inflate(R.menu.options,menu.getMenu());
                menu.show();
            }
        });
    }
}