package org.me.gcu.ip3;

import androidx.camera.core.ImageAnalysis;

import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;

//public class BarcodeScanner {
//    BarcodeScannerOptions options =
//            new BarcodeScannerOptions.Builder()
//                    .setBarcodeFormats(Barcode.FORMAT_EAN_13, Barcode.FORMAT_EAN_8,
//                            Barcode.FORMAT_UPC_A, Barcode.FORMAT_UPC_E)
//                    .build();
//
//    InputImage image = InputImage.fromMediaImage(mediaImage, rotation);
//
//}

//private class YourAnalyzer implements ImageAnalysis.Analyzer {
//
//    @Override
//    public void analyze(ImageProxy imageProxy) {
//        Image mediaImage = imageProxy.getImage();
//        if (mediaImage != null) {
//            InputImage image =
//                    InputImage.fromMediaImage(mediaImage, imageProxy.getImageInfo().getRotationDegrees());
//            // Pass image to an ML Kit Vision API
//            // ...
//        }
//    }
//}

