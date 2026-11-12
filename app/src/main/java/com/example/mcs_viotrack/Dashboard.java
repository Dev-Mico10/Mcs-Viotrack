package com.example.mcs_viotrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

class DashboardActivity extends AppCompatActivity {

    Button btnViewHistory, btnGenerateReport, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);

        // Link buttons
        btnViewHistory = findViewById(R.id.button3);
        btnGenerateReport = findViewById(R.id.button4);

        // View Violation History — navigate when clicked
        btnViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, cenerateviolationreportcompilestudentsrecordviolationreportgenerated.class);
            startActivity(intent);
        });

        // Generate Violation Report — navigate when clicked
        btnGenerateReport.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, violationtype.class);
            startActivity(intent);
        });

        // Log Out — go back to Login screen
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}