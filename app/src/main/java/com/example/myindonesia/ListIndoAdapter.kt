package com.example.myindonesia

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myindonesia.databinding.ItemRowIndoBinding

class ListIndoAdapter(private val listIndo: ArrayList<Indo>) : RecyclerView.Adapter<ListIndoAdapter.ListViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        context = parent.context
        val binding = ItemRowIndoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, cost, accommodation, food) = listIndo[position]
        val currentItem = listIndo[position]

        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.binding.root.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("name", currentItem.name)
                putExtra("description", currentItem.description)
                putExtra("photo", currentItem.photo)
                putExtra("cost", cost)  // Memasukkan informasi biaya ke dalam Intent
                putExtra("accommodation", accommodation)  // Memasukkan informasi akomodasi ke dalam Intent
                putExtra("food", food)  // Memasukkan informasi makanan ke dalam Intent
            }
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = listIndo.size

    class ListViewHolder(val binding: ItemRowIndoBinding) : RecyclerView.ViewHolder(binding.root)
}


