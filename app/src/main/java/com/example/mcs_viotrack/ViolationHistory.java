
package com.example.mcs_viotrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViolationHistory extends AppCompatActivity {

    Button btnViewViolationHistory;
    Button btnFetchViolationRecords;
    Button btnCompleteViolationHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violation_history);

        // Initialize buttons
        btnViewViolationHistory =
                findViewById(R.id.btnViewViolationHistory);

        btnFetchViolationRecords =
                findViewById(R.id.btnFetchViolationRecords);

        btnCompleteViolationHistory =
                findViewById(R.id.btnCompleteViolationHistory);

        // View Violation History
        btnViewViolationHistory.setOnClickListener(v -> {
            Toast.makeText(
                    ViolationHistory.this,
                    "Viewing violation history",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // Fetch Violation Records
        btnFetchViolationRecords.setOnClickListener(v -> {
            Toast.makeText(
                    ViolationHistory.this,
                    "Violation records fetched successfully",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // Complete History
        btnCompleteViolationHistory.setOnClickListener(v -> {
            Toast.makeText(
                    ViolationHistory.this,
                    "Complete violation history is displayed",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
