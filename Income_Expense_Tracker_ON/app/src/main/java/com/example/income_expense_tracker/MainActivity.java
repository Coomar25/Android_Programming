package com.example.income_expense_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView txtIncome, txtExpenses, txtBalance, txtDetails;
    Button btnEntry, btnReport;
    MyDatabase myDatabase;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIncome = findViewById(R.id.txtIncome);
        txtBalance = findViewById(R.id.txtBalance);
        txtExpenses = findViewById(R.id.txtExpenses);
        txtDetails = findViewById(R.id.txtDetails);

        btnEntry = findViewById(R.id.btnEntry);
        btnReport = findViewById(R.id.btnReport);
        myDatabase = new MyDatabase(this);

        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewDataEntry.class);
                startActivity(intent);
            }
        });

        txtDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TodayDetails.class);
                startActivity(intent);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DateWiseReport.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDate();
    }

    public void loadDate() {
        cursor = myDatabase.selectData(getCurrentDate());
        int income = 0, expenses = 0, balance = 0;
        while (cursor.moveToNext()) {
            income += cursor.getInt(2);
            expenses += cursor.getInt(3);
        }
        balance = income - expenses;
        txtIncome.setText(income + " ");
        txtExpenses.setText(expenses + "");
        txtBalance.setText(balance + "");
    }

    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dat = formatter.format(date);
        return dat;
    }

}
