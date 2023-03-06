package org.me.gcu.ip3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.example.cameraxapp.CameraXAppKt;

public class MainActivity extends AppCompatActivity {



   private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Replace the default fragment with the LoginFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())
                .commit();

//        Working on it
//        mLoginButton = findViewById(R.id.login_button);
//        mLoginButton.setOnClickListenr(new View.OnClickListener(){
//
//            public void onClick(View v){
//
//                startActivity(new Intent(MainActivity.this, CameraXAppKt.class));
//
//            }
//
//        });
    }




}


