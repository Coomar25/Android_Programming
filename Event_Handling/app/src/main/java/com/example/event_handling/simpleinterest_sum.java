package com.example.event_handling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class simpleinterest_sum extends AppCompatActivity {

    EditText principal;
    EditText time;
    EditText rate;
    TextView answer;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleinterest_sum);
        EditText principal = (EditText)findViewById(R.id.principal);
        EditText rate = (EditText)findViewById(R.id.rate);
        EditText time = (EditText)findViewById(R.id.time);
        TextView answer = (TextView)findViewById(R.id.textView2);
        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int p =Integer.parseInt(principal.getText().toString());
                int t = Integer.parseInt(time.getText().toString());
                int r = Integer.parseInt(rate.getText().toString());
                int ans = (p*t*r)/100;
                answer.setText(Integer.toString(ans));
//                answer.setText(String.valueOf(ans));
//                answer.setText(ans);



            }
        });


    }
}