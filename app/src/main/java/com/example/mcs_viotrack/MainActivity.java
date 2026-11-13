package com.example.mcs_viotrack;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends Activity {

    EditText username, password;
    Button loginButton;
    TextView forgotPasswordText;  // ✅ Changed from Button to TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        // Link variables to your layout elements
        username = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button);
        forgotPasswordText = findViewById(R.id.tvForgotPassword);  // ✅ Updated variable name

        // Login button click action
        loginButton.setOnClickListener(v -> {
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Please enter your username and password",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Login successful",
                        Toast.LENGTH_SHORT).show();

                // Open Dashboard Screen
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
                finish(); // Close login screen so user can't go back
            }
        });

        // ✅ FIXED Forgot Password — Using Simple Dialog Instead
        forgotPasswordText.setOnClickListener(v -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.forgotpassword);
            dialog.setCancelable(true);

            Button okButton = dialog.findViewById(R.id.btn_ok);
            okButton.setOnClickListener(btn -> dialog.dismiss());

            dialog.show();
        });
    }
}
