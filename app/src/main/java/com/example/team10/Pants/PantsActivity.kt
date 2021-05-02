package com.example.team10.Pants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.team10.R
import com.example.team10.databinding.ActivityPantsBinding
import kotlinx.android.synthetic.main.activity_pants.*


class PantsActivity:AppCompatActivity() {
    private lateinit var binding: ActivityPantsBinding
    private lateinit var viewModel: PantsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PantsViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pants)

        val adapter = PantsAdapter()
        binding.PantsList.adapter = adapter
        adapter.data = getdataSet()
        PantsList.layoutManager = GridLayoutManager(this, 2)
    }
}
