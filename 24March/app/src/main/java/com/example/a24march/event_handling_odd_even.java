package com.example.a24march;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class event_handling_odd_even extends AppCompatActivity {

    Button b;

    EditText e;

    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling_odd_even);

       EditText e= (EditText)findViewById(R.id.num1);
        b= (Button)findViewById(R.id.calculate);
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

    }
}