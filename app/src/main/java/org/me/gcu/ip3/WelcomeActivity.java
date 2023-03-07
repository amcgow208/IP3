package org.me.gcu.ip3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.welcome_container, new WelcomeFragment())
                .commit();
    }

}
