package com.example.ch3_menu_makanan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ch3_menu_makanan.databinding.FragmentDetailBinding
import com.example.ch3_menu_makanan.databinding.FragmentHomeBinding


class FragmentDetail : Fragment() {
    lateinit var binding : FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        val ambilDataMenu = bundle!!.getString("menu")
        val ambilDataharga = bundle!!.getString("harga")
        val ambilDataimeage = bundle!!.getInt("imeage")
        val ambilDataketerangan = bundle!!.getString("keterangan")
        val ambilDatakelokasi = bundle!!.getString("lokasi")
        binding.tvFoodName.text = ambilDataMenu
        binding.tvHargaDetail.text = ambilDataharga
        Glide.with(requireContext()).load(ambilDataimeage).into(binding.ivProvImg)
        binding.tvLocation.text = ambilDatakelokasi
        binding.keterangan.text = ambilDataketerangan

        Glide.with(requireContext()).load(ambilDataimeage).into(binding.banner)
        binding.ivBack.setOnClickListener {
           Navigation.findNavController(it).navigate(R.id.action_fragmentDetail_to_fragment_Home)
        }
        binding.ivMaps.setOnClickListener{
            val data = binding.tvLocation.text.toString()
            val uri = Uri.parse("https://www.google.com/maps/search/$data")
            val mapIntent=Intent(Intent.ACTION_VIEW,uri)
            startActivity(mapIntent)
        }

    }


}
