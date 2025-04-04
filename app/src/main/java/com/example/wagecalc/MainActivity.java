package com.example.wagecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText hourlyRateEditText, hoursWorkedEditText;
    private Button calculateButton;
    private TextView weeklyWageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourlyRateEditText = findViewById(R.id.hourlyRateEditText);
        hoursWorkedEditText = findViewById(R.id.hoursWorkedEditText);
        calculateButton = findViewById(R.id.calculateButton);
        weeklyWageTextView = findViewById(R.id.weeklyWageTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWeeklyWage();
            }
        });
    }

    private void calculateWeeklyWage() {
        double hourlyRate = Double.parseDouble(hourlyRateEditText.getText().toString());
        double hoursWorked = Double.parseDouble(hoursWorkedEditText.getText().toString());

        double weeklyWage = hourlyRate * hoursWorked;
        weeklyWageTextView.setText(String.format("Your weekly wage is: $%.2f", weeklyWage));
    }
}