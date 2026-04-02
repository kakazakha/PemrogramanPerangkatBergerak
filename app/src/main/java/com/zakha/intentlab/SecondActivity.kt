package com.zakha.intentlab

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Tangkap data berdasarkan kuncinya [cite: 123, 129]
        val nama = intent.getStringExtra(MainActivity.EXTRA_NAMA) ?: "Tidak ada"
        val nim = intent.getIntExtra(MainActivity.EXTRA_NIM, 0)
        val aktif = intent.getBooleanExtra(MainActivity.EXTRA_AKTIF, false)

        // Tampilkan ke TextView [cite: 131, 132]
        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = """
            Nama  : $nama
            NIM   : $nim
            Aktif : $aktif
        """.trimIndent()
    }
}