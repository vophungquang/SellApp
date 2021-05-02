package com.example.team10.Pants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.team10.R
import com.squareup.picasso.Picasso

class PantsAdapter: RecyclerView.Adapter<PantsAdapter.ViewHolder>() {

    var data: List<Pants> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.grid_pants, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvname.text = item.name
        holder.tvprice.text = item.price
        Picasso.get().load(item.avatar).into(holder.imgPants)

    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname = itemView.findViewById<TextView>(R.id.pants_name)
        val tvprice = itemView.findViewById<TextView>(R.id.pants_price)
        val imgPants = itemView.findViewById<ImageView>(R.id.pants_image)!!
    }
}