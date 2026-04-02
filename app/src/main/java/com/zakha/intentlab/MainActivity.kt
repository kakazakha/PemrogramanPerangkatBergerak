package com.zakha.intentlab

import android.widget.TextView
import android.net.Uri
import android.widget.Button
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA = "com.intentlab.EXTRA_NAMA"
        const val EXTRA_NIM = "com.intentlab.EXTRA_NIM"
        const val EXTRA_AKTIF = "com.intentlab.EXTRA_AKTIF"
    }

    private val formLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val nama = result.data?.getStringExtra("HASIL_NAMA")
            val tvHasil = findViewById<TextView>(R.id.tvHasil)
            tvHasil.text = "Nama dari form: $nama"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGo = findViewById<Button>(R.id.btnGo)
        btnGo.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_NAMA, "Kaka Zakha")
                putExtra(EXTRA_NIM, 105223019)
                putExtra(EXTRA_AKTIF, true)
            }
            startActivity(intent)
        }

        val btnOpenUrl = findViewById<Button>(R.id.btnOpenUrl)
        btnOpenUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pertamina-university.ac.id"))
            startActivity(intent)
        }

        val btnDialPhone = findViewById<Button>(R.id.btnDialPhone)
        btnDialPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+62211234567"))
            startActivity(intent)
        }

        val btnShare = findViewById<Button>(R.id.btnShare)
        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Info Perkuliahan")
                putExtra(Intent.EXTRA_TEXT, "Halo! Ini pesan dari IntentLab App.")
            }
            startActivity(Intent.createChooser(intent, "Bagikan melalui..."))
        }

        val btnIsiForm = findViewById<Button>(R.id.btnIsiForm)
        btnIsiForm.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            formLauncher.launch(intent)
        }
    }
}