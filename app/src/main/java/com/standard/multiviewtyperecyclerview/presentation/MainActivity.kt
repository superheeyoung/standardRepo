package com.standard.multiviewtyperecyclerview.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.flowerrecyclerview.data.DataSource
import com.standard.multiviewtyperecyclerview.data.Card
import com.standard.multiviewtyperecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val multiCardAdapter : MultiCardAdapter by lazy {
        MultiCardAdapter { card ->
            adapterOnClick(card)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val cardList = DataSource.getDataSource().getCardList()
        multiCardAdapter.cardList = cardList

        with(binding.rvItem) {
            adapter = multiCardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun adapterOnClick(card : Card) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}