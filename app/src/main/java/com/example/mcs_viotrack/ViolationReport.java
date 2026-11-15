package com.example.mcs_viotrack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViolationReport extends Activity {

    private Button btnGenerateViolationReport;
    private Button btnCompileStudentsRecord;
    private Button button2;  // ✅ Back button

    private TextView tvReportStatus;
    private TextView tvReportMessage;
    private TextView tvViolationList;

    public ViolationReport() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.violationreport);

        // Initialize ALL views
        btnGenerateViolationReport = findViewById(R.id.btnGenerateViolationReport);
        btnCompileStudentsRecord = findViewById(R.id.btnCompileStudentsRecord);
        button2 = findViewById(R.id.button2);  // ✅ Link your new button

        tvReportStatus = findViewById(R.id.tvReportStatus);
        tvReportMessage = findViewById(R.id.tvReportMessage);
        tvViolationList = findViewById(R.id.btnViewViolationHistory);

        // Existing buttons
        btnGenerateViolationReport.setOnClickListener(v -> generateViolationReport());
        btnCompileStudentsRecord.setOnClickListener(v -> compileStudentsRecord());

        // ✅ Back to Dashboard
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(ViolationReport.this, Dashboard.class);
            startActivity(intent);
            finish(); // Optional: closes this screen so pressing back doesn't return here
        });
    }

    private void generateViolationReport() {
        String violations = ViolationStorage.getViolations(this);

        tvReportStatus.setText("Violation Report Generated");
        tvReportMessage.setText("Your saved violation records:");
        tvViolationList.setText(violations);

        Toast.makeText(this, "Violation Report Generated!", Toast.LENGTH_SHORT).show();
    }

    private void compileStudentsRecord() {
        tvReportStatus.setText("Record Status");
        tvReportMessage.setText("Student records compilation requested.");
        Toast.makeText(this, "Compiling Student Records...", Toast.LENGTH_SHORT).show();
    }
}
