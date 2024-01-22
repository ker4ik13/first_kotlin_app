package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.model.Product

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val itemsActivityTitle: TextView = findViewById(R.id.itemsTitle)
        val items =  arrayListOf<Product>()

        items.add(Product(1, "sofa", "Диван", "Desc 1",  299))
        items.add(Product(2, "light", "Свет", "Desc 2",  399))
        items.add(Product(3, "kitchen", "Кухня", "Desc 3",  5990))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ProductsAdapter(items)
        itemsActivityTitle.text = "${itemsActivityTitle.text} (${items.count()})"
    }
}