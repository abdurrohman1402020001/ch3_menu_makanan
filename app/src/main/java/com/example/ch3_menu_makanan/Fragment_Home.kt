package com.example.ch3_menu_makanan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chalange3_menu_makanan.Food
import com.example.ch3_menu_makanan.databinding.FragmentHomeBinding


class Fragment_Home : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ambilDataGrid()
        binding.switch1.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked){
                ambilDataList()
            }else{
                ambilDataGrid()
            }
        }
    }

    private fun ambilDataGrid(){
        binding.rvMenu.adapter = MainAdapter(DataDumy.listData)
        binding.rvMenu.layoutManager = GridLayoutManager(context, 2)
    }
    private fun ambilDataList(){
        binding.rvMenu.adapter = MainAdapter(DataDumy.listData)
        binding.rvMenu.layoutManager = LinearLayoutManager(context)
    }
}