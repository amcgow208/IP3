package org.me.gcu.ip3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button mCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_welcome);

        mCameraButton = findViewById(R.id.camera_button);

        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.welcome_container, new WelcomeFragment())
//                .commit();


    }
}
