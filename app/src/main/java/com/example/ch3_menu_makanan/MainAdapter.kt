package com.example.ch3_menu_makanan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chalange3_menu_makanan.Food
import com.example.ch3_menu_makanan.databinding.ListItemBinding

class MainAdapter(private val food: ArrayList<Food>):RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    inner class ListViewHolder( val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food){
            Glide.with(itemView).load(food.image).into(binding.ivMenu)
            binding.tvNamaMakanan.text = food.name
            binding.tvPriceFood.text = food.price

        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
        ): ListViewHolder{
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return food.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(food[position])
        holder.binding.root.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("menu", food[position].name)
            bundle.putString("harga", food[position].price)
            bundle.putInt("imeage", food[position].image)
            bundle.putString("keterangan", food[position].description)
            bundle.putString("lokasi", food[position].location)
            Navigation.findNavController(it).navigate(R.id.action_fragment_Home_to_fragmentDetail, bundle)///memindahkan fragment ke fragment lainnya
        }
    }
}