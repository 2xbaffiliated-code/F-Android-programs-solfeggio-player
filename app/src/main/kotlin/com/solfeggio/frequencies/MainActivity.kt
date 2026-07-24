package com.solfeggio.frequencies

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.solfeggio.frequencies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var soundManager: SoundManager
    private val frequencies = listOf(174, 285, 396, 417, 528, 639, 741, 852, 963)
    private val PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        soundManager = SoundManager(this)

        // Request permissions
        requestPermissions()

        // Setup UI buttons
        setupButtons()
    }

    private fun requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_MEDIA_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_MEDIA_AUDIO),
                    PERMISSION_REQUEST_CODE
                )
            }
        } else {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    PERMISSION_REQUEST_CODE
                )
            }
        }
    }

    private fun setupButtons() {
        // 174 Hz
        binding.btnPlay174.setOnClickListener { soundManager.play(174) }
        binding.btnPause174.setOnClickListener { soundManager.pause(174) }
        binding.btnRepeat174.setOnClickListener { soundManager.repeat(174) }

        // 285 Hz
        binding.btnPlay285.setOnClickListener { soundManager.play(285) }
        binding.btnPause285.setOnClickListener { soundManager.pause(285) }
        binding.btnRepeat285.setOnClickListener { soundManager.repeat(285) }

        // 396 Hz
        binding.btnPlay396.setOnClickListener { soundManager.play(396) }
        binding.btnPause396.setOnClickListener { soundManager.pause(396) }
        binding.btnRepeat396.setOnClickListener { soundManager.repeat(396) }

        // 417 Hz
        binding.btnPlay417.setOnClickListener { soundManager.play(417) }
        binding.btnPause417.setOnClickListener { soundManager.pause(417) }
        binding.btnRepeat417.setOnClickListener { soundManager.repeat(417) }

        // 528 Hz
        binding.btnPlay528.setOnClickListener { soundManager.play(528) }
        binding.btnPause528.setOnClickListener { soundManager.pause(528) }
        binding.btnRepeat528.setOnClickListener { soundManager.repeat(528) }

        // 639 Hz
        binding.btnPlay639.setOnClickListener { soundManager.play(639) }
        binding.btnPause639.setOnClickListener { soundManager.pause(639) }
        binding.btnRepeat639.setOnClickListener { soundManager.repeat(639) }

        // 741 Hz
        binding.btnPlay741.setOnClickListener { soundManager.play(741) }
        binding.btnPause741.setOnClickListener { soundManager.pause(741) }
        binding.btnRepeat741.setOnClickListener { soundManager.repeat(741) }

        // 852 Hz
        binding.btnPlay852.setOnClickListener { soundManager.play(852) }
        binding.btnPause852.setOnClickListener { soundManager.pause(852) }
        binding.btnRepeat852.setOnClickListener { soundManager.repeat(852) }

        // 963 Hz
        binding.btnPlay963.setOnClickListener { soundManager.play(963) }
        binding.btnPause963.setOnClickListener { soundManager.pause(963) }
        binding.btnRepeat963.setOnClickListener { soundManager.repeat(963) }
    }

    override fun onDestroy() {
        soundManager.release()
        super.onDestroy()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                // Handle permission denied
                android.util.Log.w("MainActivity", "Permission denied for audio access")
            }
        }
    }
}
