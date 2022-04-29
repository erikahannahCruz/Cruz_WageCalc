package com.example.cruz_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        calculate.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnCalculate:
                int selectedEmpType = empType.getCheckedRadioButtonId();
                    btnSelected = findViewById(selectedEmpType);

                    String type = btnSelected.getText().toString();

                    String name = empName.getText().toString();
                    String totalHours = (empHours.getText().toString());

                    Intent i = new Intent(this, Display.class);

                    i.putExtra("type",type);
                    i.putExtra("empName", name);
                    i.putExtra("hours" , totalHours);
                    startActivity(i);

                break;

        }

    }

}