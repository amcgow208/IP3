package org.me.gcu.ip3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements CameraFragment.OnBarcodeScannedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the LoginFragment by default
        loadFragment(new LoginFragment());
    }

    public Fragment loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        return fragment;
    }

    @Override
    public void onBarcodeScanned(FoodItem foodItem) {
        Log.d("MainActivity-FoodItem", foodItem.toString());
        Log.d("MainActivity-Label", foodItem.getLabel());
        Log.d("MainActivity-Nutrients", foodItem.getNutrients().toString());
        Log.d("MainActivity-Brand", foodItem.getBrand());
        Log.d("MainActivity-Category", foodItem.getCategory());
        Log.d("MainActivity-FoodContents", foodItem.getFoodContentsLabel());
        Log.d("MainActivity-Image", foodItem.getImage());
        // Handle the navigation to FoodInfoFragment
        FoodInfoFragment foodInfoFragment = new FoodInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("foodItem", foodItem);
        foodInfoFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, foodInfoFragment)
                .addToBackStack(null)
                .commit();
    }

}
