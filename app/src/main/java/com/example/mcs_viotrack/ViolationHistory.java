package com.example.mcs_viotrack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViolationHistory extends AppCompatActivity {

    Button btnViewViolationHistory;
    Button btnFetchViolationRecords;
    Button btnCompleteViolationHistory;
    Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violation_history);

        // Initialize buttons
        btnViewViolationHistory = findViewById(R.id.btnViewViolationHistory);
        btnFetchViolationRecords = findViewById(R.id.btnFetchViolationRecords);
        btnCompleteViolationHistory = findViewById(R.id.btnCompleteViolationHistory);
        button2 = findViewById(R.id.button2);

        // --- Quick check: show message if button2 is missing ---
        if (button2 == null) {
            Toast.makeText(this, "❌ ERROR: button2 not found in layout!", Toast.LENGTH_LONG).show();
            return;
        }

        // View Violation History
        btnViewViolationHistory.setOnClickListener(v ->
                Toast.makeText(ViolationHistory.this, "Viewing violation history", Toast.LENGTH_SHORT).show()
        );

        // Fetch Violation Records
        btnFetchViolationRecords.setOnClickListener(v ->
                Toast.makeText(ViolationHistory.this, "Violation records fetched successfully", Toast.LENGTH_SHORT).show()
        );

        // Complete History
        btnCompleteViolationHistory.setOnClickListener(v ->
                Toast.makeText(ViolationHistory.this, "Complete violation history is displayed", Toast.LENGTH_SHORT).show()
        );

        // ✅ BACK TO DASHBOARD — Simplified
        button2.setOnClickListener(v -> {
            Toast.makeText(ViolationHistory.this, "Going back to Dashboard...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ViolationHistory.this, Dashboard.class);
            startActivity(intent);
            // finish(); // ← Try WITH and WITHOUT this line
        });
    }
}
