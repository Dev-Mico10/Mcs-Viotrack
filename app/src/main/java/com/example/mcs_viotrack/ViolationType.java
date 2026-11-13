
package com.example.mcs_viotrack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViolationType extends Activity {

    private EditText name;
    private EditText category;
    private EditText penalty;

    private Button saveButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.violationtype);

        // Connect XML components
        name = findViewById(R.id.Name);
        category = findViewById(R.id.editTextText2);
        penalty = findViewById(R.id.editTextText3);

        saveButton = findViewById(R.id.button5);
        backButton = findViewById(R.id.Button);

        // SAVE VIOLATION BUTTON
        saveButton.setOnClickListener(v -> {

            String violationName =
                    name.getText().toString().trim();

            String violationCategory =
                    category.getText().toString().trim();

            String violationPenalty =
                    penalty.getText().toString().trim();

            // Check empty fields
            if (violationName.isEmpty() ||
                    violationCategory.isEmpty() ||
                    violationPenalty.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please fill in all fields.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Save violation
            boolean saved = ViolationStorage.saveViolation(
                    this,
                    violationName,
                    violationCategory,
                    violationPenalty
            );

            if (saved) {

                Toast.makeText(
                        this,
                        "Violation saved successfully!",
                        Toast.LENGTH_SHORT
                ).show();

                // Clear input fields
                name.setText("");
                category.setText("");
                penalty.setText("");

            } else {

                Toast.makeText(
                        this,
                        "Unable to save violation.",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // BACK BUTTON
        backButton.setOnClickListener(v -> finish());
    }
}

