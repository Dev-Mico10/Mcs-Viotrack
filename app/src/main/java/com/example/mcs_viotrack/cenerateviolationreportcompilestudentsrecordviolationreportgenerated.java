
package com.example.mcs_viotrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cenerateviolationreportcompilestudentsrecordviolationreportgenerated
        extends AppCompatActivity {

    private Button btnGenerateViolationReport;
    private Button btnCompileStudentsRecord;

    private TextView tvReportStatus;
    private TextView tvReportMessage;
    private TextView tvViolationList = findViewById(R.id.btnViewViolationHistory);

    public cenerateviolationreportcompilestudentsrecordviolationreportgenerated() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.cenerateviolationreportcompilestudentsrecordviolationreportgeneratedcenerateviolationreportcompilestudentsrecordviolationreportgenerated
        );

        // Initialize buttons
        btnGenerateViolationReport =
                findViewById(R.id.btnGenerateViolationReport);

        btnCompileStudentsRecord =
                findViewById(R.id.btnCompileStudentsRecord);

        // Initialize TextViews
        tvReportStatus =
                findViewById(R.id.tvReportStatus);

        tvReportMessage =
                findViewById(R.id.tvReportMessage);

        // Generate Violation Report
        btnGenerateViolationReport.setOnClickListener(v -> {
            generateViolationReport();
        });

        // Compile Students Record
        btnCompileStudentsRecord.setOnClickListener(v -> {
            compileStudentsRecord();
        });
    }

    // Generate Violation Report
    private void generateViolationReport() {

        String violations =
                ViolationStorage.getViolations(this);

        tvReportStatus.setText(
                "Violation Report Generated"
        );

        tvReportMessage.setText(
                "Your saved violation records:"
        );

        tvViolationList.setText(violations);

        Toast.makeText(
                this,
                "Violation Report Generated!",
                Toast.LENGTH_SHORT
        ).show();
    }

    // Compile Students Record
    private void compileStudentsRecord() {

        tvReportStatus.setText(
                "Record Status"
        );

        tvReportMessage.setText(
                "Student records compilation requested."
        );

        Toast.makeText(
                this,
                "Compiling Student Records...",
                Toast.LENGTH_SHORT
        ).show();
    }
}
