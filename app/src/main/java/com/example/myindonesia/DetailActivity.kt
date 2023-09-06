package com.example.myindonesia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myindonesia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val photoResId = intent.getIntExtra("photo", 0)
        val cost = intent.getStringExtra("cost")  // Ambil informasi biaya
        val accommodation = intent.getStringExtra("accommodation")  // Ambil informasi akomodasi
        val food = intent.getStringExtra("food")  // Ambil informasi makanan

        binding.imgDetailPhoto.setImageResource(photoResId)
        binding.tvDetailName.text = name
        binding.tvDetailDescription.text = description

        // Tambahkan TextViews baru untuk informasi biaya, akomodasi, dan makanan
        binding.tvDetailCost.text = "Biaya: $cost"
        binding.tvDetailAccommodation.text = "Akomodasi: $accommodation"
        binding.tvDetailFood.text = "Makanan: $food"

        // Temukan Tombol Share berdasarkan ID-nya
        val tombolShare = binding.root.findViewById<Button>(R.id.action_share)

        // Atur OnClickListener untuk Tombol Share
        tombolShare.setOnClickListener {
            val intentBagikan = Intent(Intent.ACTION_SEND)
            intentBagikan.type = "text/plain"
            intentBagikan.putExtra(Intent.EXTRA_SUBJECT, "Judul Bagikan")
            intentBagikan.putExtra(Intent.EXTRA_TEXT, "Teks Bagikan: $name - $description")

            startActivity(Intent.createChooser(intentBagikan, "Bagikan melalui"))
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
