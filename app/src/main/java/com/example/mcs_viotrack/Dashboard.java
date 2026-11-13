package com.example.mcs_viotrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class Dashboard extends Activity {

    Button btnViewHistory, btnGenerateReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Link buttons to your XML IDs
        btnViewHistory = findViewById(R.id.button3);
        btnGenerateReport = findViewById(R.id.button4);

        // View Violation History Button
        btnViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ViolationStorage.class);
            startActivity(intent);
        });

        // Generate Violation Report Button
        btnGenerateReport.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ViolationType.class);
            startActivity(intent);
        });
    }
}
