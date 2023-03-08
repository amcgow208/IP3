package org.me.gcu.ip3

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class CameraActivity : AppCompatActivity() {

    // Create a new instance of your CameraXFragment
    private val cameraFragment = CameraFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        // Use a FragmentTransaction to add the fragment to the activity
        supportFragmentManager.beginTransaction()
            .replace(R.id.camera_container, cameraFragment)
            .commit()
    }

    companion object {
        const val TAG = "IP3"
        const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf (
                Manifest.permission.CAMERA,
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

}

