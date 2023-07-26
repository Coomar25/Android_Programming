package com.example.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistratinPage extends AppCompatActivity {

    private EditText nameEditText, usernameEditText, passwordEditText, emailEditText;
    private Button registerButton;
    RadioGroup radioGroupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registratin_page);


        registerButton = (Button)findViewById(R.id.registerButton);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGender);
        nameEditText = findViewById(R.id.editTextTextPersonName);
        usernameEditText = findViewById(R.id.editTextTextPersonUserName);
        passwordEditText = findViewById(R.id.editTextNumberPassword);
        emailEditText = findViewById(R.id.editTextTextPersonEmail);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton a = (RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId());
                Toast.makeText(RegistratinPage.this, "", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RegistratinPage.this, DisplayData.class);
                i.putExtra("name", nameEditText.getText().toString());
                i.putExtra("uname", usernameEditText.getText().toString());
                i.putExtra("email", emailEditText.getText().toString());
                i.putExtra("gender", a.getText().toString());
                i.putExtra("password", passwordEditText.getText().toString());
                startActivity(i);
            }
        });
    }
}
