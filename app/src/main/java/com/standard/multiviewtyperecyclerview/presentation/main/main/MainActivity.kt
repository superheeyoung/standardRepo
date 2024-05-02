package com.standard.multiviewtyperecyclerview.presentation.main.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.multiviewtyperecyclerview.databinding.ActivityMainBinding
import com.standard.multiviewtyperecyclerview.presentation.main.detail.DetailActivity
import com.standard.multiviewtyperecyclerview.presentation.main.model.BlueCardModel

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val multiCardAdapter : MultiCardAdapter by lazy {
        MultiCardAdapter { card ->
            adapterOnClick(card)
        }
    }

    private lateinit var cardList : List<BlueCardModel>

    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewModel()
        initData()
    }

    private fun initData() {
        mainViewModel.getBlueCardModel()
    }

    private fun initView() {
        multiCardAdapter.cardList = cardList
        with(binding.rvItem) {
            adapter = multiCardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    private fun initViewModel() {
        mainViewModel.getBlueCardModel.observe(this@MainActivity) {
            cardList = it

            initView()
        }
    }

    private fun adapterOnClick(card : BlueCardModel) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}