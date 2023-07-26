package com.example.income_expense_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewDataEntry extends AppCompatActivity {
    EditText edtDate, edtAmount;
    Spinner spTitle;
    Button btnSubmit;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data_entry);

        edtDate = findViewById(R.id.edtDate);
        edtAmount = findViewById(R.id.edtAmount);
        spTitle =findViewById(R.id.spTitle);
        btnSubmit = findViewById(R.id.btnSubmit);
        myDatabase = new MyDatabase(this);
        edtDate.setText(MainActivity.getCurrentDate());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = edtDate.getText().toString();
                String title = spTitle.getSelectedItem().toString();
                String amount = edtAmount.getText().toString();

                if(date.equals("")){
                    Toast.makeText(NewDataEntry.this, "Please enter Date", Toast.LENGTH_LONG).show();
                } else if (amount.equals("")){
                    Toast.makeText(NewDataEntry.this, "Please Enter Amount", Toast.LENGTH_LONG).show();
                }else if (title.equals("")){
                    Toast.makeText(NewDataEntry.this, "Please Enter title", Toast.LENGTH_SHORT).show();
                }else{
                    if(title.equals("Income"))
                        myDatabase.insertData(date, amount, "0");
                    else
                        myDatabase.insertData(date, "0", amount);
                    Toast.makeText(NewDataEntry.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    edtAmount.setText("");
                    spTitle.setSelection(0);
                }
            }
        });
    }
}
