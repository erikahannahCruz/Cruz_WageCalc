package com.example.cruz_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText empName , empHours;
    RadioGroup empType;
    RadioButton btnSelected;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empName = findViewById(R.id.txtName);
        empHours = findViewById(R.id.txtNumber);
        empType = findViewById(R.id.radGroup);
        calculate = findViewById(R.id.btnCalculate);
    }
}