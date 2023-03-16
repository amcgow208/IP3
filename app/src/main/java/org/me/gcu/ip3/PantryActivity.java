package org.me.gcu.ip3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PantryActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.pantry_container, new PantryFragment())
                .commit();
    }

}
