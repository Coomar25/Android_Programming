package com.example.event_handling;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText e;
    TextView t;

    Button nextpageBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e= (EditText)findViewById(R.id.num1);
        b= (Button)findViewById(R.id.calculate);
        nextpageBtn = (Button)findViewById(R.id.button2);
        t = (TextView)findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int n1 = Integer.parseInt(e.getText().toString());
                System.out.println(n1);
                if(n1%2==0){
                    t.setText("Even");
                }else{
                    t.setText("odd");
                }
            }
        });

        nextpageBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this,simpleinterest_sum.class);
                startActivity(i);
        }
        });



    }
}