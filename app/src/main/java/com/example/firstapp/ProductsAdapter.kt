package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.model.Product

class ProductsAdapter (private var items: List<Product>): RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    class MyViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.itemListImage)
        val title: TextView = view.findViewById(R.id.itemListTitle)
        val description: TextView = view.findViewById(R.id.itemListDescription)
        val price: TextView = view.findViewById(R.id.itemListPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.description.text = items[position].description
        holder.price.text = items[position].price.toString()

        val imageId = holder.itemView.context.resources.getIdentifier(
            items[position].image,
            "drawable",
            holder.itemView.context.packageName
        )

        holder.image.setImageResource(imageId)
    }
}