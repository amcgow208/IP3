package org.me.gcu.ip3;

// LoginActivity.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        // Get references to UI elements
        mUsernameEditText = findViewById(R.id.username);
        mPasswordEditText = findViewById(R.id.password);
        mLoginButton = findViewById(R.id.login_button);

        // Set up click listener for login button
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get username and password
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                // TODO: Check user's credentials

                // If the login is successful, display a toast message and navigate to the next screen
                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(LoginActivity.this, NextActivity.class);
                // startActivity(intent);
            }
        });
    }
}
