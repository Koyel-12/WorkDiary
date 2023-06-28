package com.example.workdiary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter(private val items: List<CRUDOperationModel>) :
    RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.crudoperation_image)
        val titleTextView: TextView = itemView.findViewById(R.id.crudoperation_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageId)
        holder.titleTextView.text = item.itemName

        holder.itemView.setOnClickListener {
            // Handle the click event for the grid item
            val context = holder.itemView.context
            when (position) {
                0 -> {
                    // Handle the click for the first grid item
                    val intent = Intent(context, AddResourceScreen::class.java)
                    // Pass any necessary data to the new activity
                    context.startActivity(intent)
                }
                1 -> {
                    // Handle the click for the second grid item
                    val intent = Intent(context, DeleteResourceScreen::class.java)
                    // Pass any necessary data to the new activity
                    context.startActivity(intent)
                }
                2 -> {
                    val intent = Intent(context, EditResourceScreen::class.java)
                    context.startActivity(intent)
                }
                3 -> {
                    val intent = Intent(context, ResourceListScreen::class.java)
                    context.startActivity(intent)
                }
                4 -> {
                    val intent = Intent(context, ReportScreen::class.java)
                    context.startActivity(intent)
                }
                else -> {
                    // Handle the click for the default case (if needed)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
