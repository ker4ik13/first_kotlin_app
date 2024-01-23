package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val image: ImageView = findViewById(R.id.itemListImage)
        val title: TextView = findViewById(R.id.itemListTitle)
        val description: TextView = findViewById(R.id.itemListDescription)
        val price: TextView = findViewById(R.id.itemListPrice)
        val buyButton: Button = findViewById(R.id.buttonBuy)

        title.text = intent.getStringExtra("itemTitle")
        description.text = intent.getStringExtra("itemDescription")
        price.text = intent.getStringExtra("itemPrice")
        image.setImageResource(intent.getStringExtra("itemImageId").toString().toInt())
    }
}