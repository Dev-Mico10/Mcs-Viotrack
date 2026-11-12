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


        btnViewHistory = findViewById(R.id.button3);
        btnGenerateReport = findViewById(R.id.button4);


        btnViewHistory.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, cenerateviolationreportcompilestudentsrecordviolationreportgenerated.class);
            startActivity(intent);
        });


        btnGenerateReport.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ViolationType.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}