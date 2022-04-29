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
        String employeeName = i.getStringExtra("empName");
        Double employeeHours = Double.parseDouble(i.getStringExtra("hours"));


        calculateWage(employeeType, employeeHours, txtOvertime, txtGrossWage, txtRegWage , txtOverWage);

        //setTexts (Name, Type, Hours Rendered)
        txtName.setText(employeeName);
        txtType.setText(String.valueOf(employeeType));
        txtHours.setText(String.valueOf(employeeHours));
    }


    //Calculation method
    public void calculateWage(String employeeType, Double employeeHours, TextView txtOvertime,
                              TextView txtGrossWage, TextView txtRegWage , TextView txtOverWage) {

        Double grossWage = 0.0 ;
        Double overWage = 0.0 ;
        Double regWage ;

        //total hours is the employeeHours
        Double hrRegular ;
        Double hrOvertime = 0.0 ;

        //Overtime hours calculation
        hrOvertime = employeeHours - 8 ;
        hrRegular = employeeHours - hrOvertime ;

            if (employeeHours > 8) {
                if (employeeType.equals("Full-Time")) {
                    regWage = hrRegular * 100;
                    overWage = hrOvertime * 115;
                    grossWage = regWage + overWage ;

                    txtOvertime.setText(String.valueOf(hrOvertime));

                    txtGrossWage.setText("₱" + String.valueOf(grossWage));
                    txtRegWage.setText("₱" + String.valueOf(regWage));
                    txtOverWage.setText("₱" + String.valueOf(overWage));
                }

                else if (employeeType.equals("Part-Time")) {
                    regWage = hrRegular * 75;
                    overWage = hrOvertime * 90;
                    grossWage = regWage + overWage ;

                    txtOvertime.setText(String.valueOf(hrOvertime));

                    txtGrossWage.setText("₱" + String.valueOf(grossWage));
                    txtRegWage.setText("₱" + String.valueOf(regWage));
                    txtOverWage.setText("₱" + String.valueOf(overWage));

                }

                else {
                    regWage = hrRegular * 90;
                    overWage = hrOvertime * 100;
                    grossWage = regWage + overWage ;

                    txtOvertime.setText(String.valueOf(hrOvertime));

                    txtGrossWage.setText("₱" + String.valueOf(grossWage));
                    txtRegWage.setText("₱" + String.valueOf(regWage));
                    txtOverWage.setText("₱" + String.valueOf(overWage));
                }

            }
            else {
                if (employeeType.equals("Full-Time")) {
                    grossWage = employeeHours * 100;


                    txtOvertime.setText(String.valueOf(hrOvertime));

                    txtGrossWage.setText("₱" + String.valueOf(grossWage));
                    txtRegWage.setText("₱" + String.valueOf(grossWage));
                    txtOverWage.setText("₱" + String.valueOf(overWage));
                }

                else if (employeeType.equals("Part-Time")) {
                    grossWage = employeeHours * 75;


                    txtOvertime.setText(String.valueOf(hrOvertime));

                    txtGrossWage.setText("₱" + String.valueOf(grossWage));
                    txtRegWage.setText("₱" + String.valueOf(grossWage));
                    txtOverWage.setText("₱" + String.valueOf(overWage));
                }

                //for Probationary
                else {
                    grossWage = employeeHours * 90;

                    txtOvertime.setText(String.valueOf(hrOvertime));

                    txtGrossWage.setText("₱" + String.valueOf(grossWage));
                    txtRegWage.setText("₱" + String.valueOf(grossWage));
                    txtOverWage.setText("₱" + String.valueOf(overWage));

                }

            }
    }


}
