package com.zakha.intentlab


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShareReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_receiver)

        // Cek apakah Activity ini dibuka lewat aksi SEND [cite: 236, 237]
        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
            val tvShared = findViewById<TextView>(R.id.tvShared)

            tvShared.text = sharedText ?: "Tidak ada teks yang dibagikan"
        }
    }
}