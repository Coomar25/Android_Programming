package com.example.sum_natural_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class TestPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_popup);
        Button btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu= new PopupMenu(TestPopup.this,btn);
                menu.getMenuInflater().inflate(R.menu.options,menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id=menuItem.getItemId();
                        switch (id){
                            case R.id.mail:
                                Toast.makeText(TestPopup.this, "Mail Item", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.share:
                                Toast.makeText(TestPopup.this, "Share item", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.upload:
                                Toast.makeText(TestPopup.this, "Upload", Toast.LENGTH_LONG).show();
                                return  true;
                            case R.id.share1:
                                Toast.makeText(TestPopup.this, "Second share", Toast.LENGTH_LONG).show();
                            default:
                                Toast.makeText(TestPopup.this, "Wrong", Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                menu.show();
            }
        });
    }
}