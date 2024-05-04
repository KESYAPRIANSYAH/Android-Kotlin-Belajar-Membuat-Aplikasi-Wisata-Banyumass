package com.dicoding.wisata_banyumas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailsWisata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_wisata)
        val photo: ImageView = findViewById(R.id.tv_image)
        val name: TextView = findViewById(R.id.name)
        val description: TextView = findViewById(R.id.descripton)
        val intent = intent
        val yName = intent.getStringExtra("xName")
        val yPhoto = intent.getStringExtra("xPhoto")
        val yDescription = intent.getStringExtra("xDescription")

        name.text = yName

        description.text = yDescription

        Glide.with(this)
            .load(yPhoto) // URL Gambar
            .into(photo)

    }
}