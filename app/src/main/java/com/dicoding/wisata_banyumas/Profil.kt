package com.dicoding.wisata_banyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Profil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_profil)

    }
}