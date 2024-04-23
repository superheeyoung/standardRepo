package com.standard.multiviewtyperecyclerview.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.standard.multiviewtyperecyclerview.data.Card
import com.standard.multiviewtyperecyclerview.databinding.ActivityDetailBinding
import com.standard.multiviewtyperecyclerview.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val cardItem = intent.getParcelableExtra<Card>(EXTRA_CARD)

        binding.detailName.text = cardItem!!.userName
        binding.detailCardNum.text = cardItem.cardNumber
        binding.detailPeiod.text = cardItem.period
        binding.detailViewType.text = cardItem.cardViewType.name
        
    }
}