package com.nischal.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity {
    Button frag1, frag2;
    LinearLayout linlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linlayout=(LinearLayout)findViewById(R.id.farglayout);
        frag1=(Button) findViewById(R.id.fragment1);
        frag2= (Button) findViewById(R.id.fragment2);
        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frag1 a=new Frag1();
                FragmentManager fmanager=getFragmentManager();
                FragmentTransaction t= fmanager.beginTransaction();
                t.replace(R.id.farglayout,a);
                t.commit();
            }
        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment( new Fragment2());
            }
        });
    }

     void loadFragment(Fragment farg){
        FragmentManager fmanager=getFragmentManager();
        FragmentTransaction t= fmanager.beginTransaction();
        t.replace(R.id.farglayout,farg);
        t.commit();

    }
}