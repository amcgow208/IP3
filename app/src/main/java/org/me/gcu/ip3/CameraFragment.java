package org.me.gcu.ip3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CameraFragment extends Fragment {

    public static final String TAG = "IP3";
    private static final int REQUEST_CODE_PERMISSIONS = 10;
    private static final String[] REQUIRED_PERMISSIONS = new String[]{Manifest.permission.CAMERA};

    private CompoundBarcodeView barcodeView;

    public CameraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (allPermissionsGranted()) {
            setupBarcodeScanner(view);
        } else {
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (allPermissionsGranted()) {
            barcodeView.resume();
            setupBarcodeScanner(getView());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }

    private void setupBarcodeScanner(View view) {
        barcodeView = view.findViewById(R.id.barcodeView);
        barcodeView.setStatusText("");

        barcodeView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                String barcodeValue = result.getText();
                queryEdamamApi(barcodeValue);
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
            }
        });
    }

    private void queryEdamamApi(String barcode) {
        String appId = "6369884d";
        String appKey = "a753cdf24eed4b05ef525a8b5d2a7d4f";
        String baseUrl = "https://api.edamam.com/";

        EdamamApiService service = RetrofitClient.getClient(baseUrl).create(EdamamApiService.class);
        Call<FoodResponse> call = service.getFoodItemByUPC(barcode, appId, appKey);

        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                if (response.isSuccessful()) {
                    FoodResponse foodResponse = response.body();
                    if (foodResponse != null && !foodResponse.getHints().isEmpty()) {
                        FoodItem foodItem = foodResponse.getHints().get(0).getFoodItem();
                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).onBarcodeScanned(foodItem);
                            Log.d("API_Response", response.raw().toString());
                        }
                    } else {
                        Log.e(TAG, "Error: No food item found in the response");
                    }
                } else {
                    Log.e(TAG, "Error in response: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });

    }
    public interface OnBarcodeScannedListener {
        void onBarcodeScanned(FoodItem foodItem);
    }

    private OnBarcodeScannedListener mListener;

    public void setOnBarcodeScannedListener(OnBarcodeScannedListener listener) {
        mListener = listener;
    }


    private boolean allPermissionsGranted() {
        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(requireContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                setupBarcodeScanner(getView());
            } else {
                Toast.makeText(requireContext(), "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}




