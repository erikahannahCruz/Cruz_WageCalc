package com.example.cruz_wagecalculator;

import android.os.Bundle;

import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {

    TextView txtName , txtType , txtHours, txtOvertime , txtRegWage , txtOverWage , txtGrossWage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        txtName = findViewById(R.id.txtEmpName);
        txtType = findViewById(R.id.txtEmpType);
        txtHours = findViewById(R.id.txtHrsTotal);
        txtOvertime = findViewById(R.id.txtHrsOvertime);
        txtRegWage = findViewById(R.id.txtWageRegular);
        txtOverWage = findViewById(R.id.txtWageOvertime);
        txtGrossWage = findViewById(R.id.txtWageGross);

        Intent i = getIntent();

        String employeeType = i.getStringExtra("type");
        String employeeName = i.getStringExtra("name");
        Double employeeHours = Double.parseDouble(i.getStringExtra("hours"));


        calculateWage(employeeType, employeeHours, txtOvertime, txtGrossWage, txtRegWage , txtOverWage);

        //setTexts (Name, Type, Hours Rendered)
        txtName.setText(employeeName);
        txtType.setText(String.valueOf(employeeType));
        txtHours.setText(String.valueOf(employeeHours));
    }

    public void calculateWage(String employeeType, Double employeeHours, TextView txtOvertime,
                              TextView txtGrossWage, TextView txtRegWage , TextView txtOverWage) {

        Double totalWage = 0.0 ;

            if (employeeHours > 8) {
                //overtime code

            }
            else {
                if (employeeType.equals("Full-Time")) {
                    totalWage = employeeHours * 100;
                    txtGrossWage.setText("₱" + String.valueOf(totalWage));
                    txtRegWage.setText("₱" + String.valueOf(totalWage));
                } else if (employeeType.equals("Part-Time")) {
                    totalWage = employeeHours * 75;
                    txtGrossWage.setText("₱" + String.valueOf(totalWage));
                    txtRegWage.setText("₱" + String.valueOf(totalWage));
                }
                //for Probationary
                else {
                    totalWage = employeeHours * 90;
                    txtGrossWage.setText("₱" + String.valueOf(totalWage));
                    txtRegWage.setText("₱" + String.valueOf(totalWage));

                }

            }
    }


}
