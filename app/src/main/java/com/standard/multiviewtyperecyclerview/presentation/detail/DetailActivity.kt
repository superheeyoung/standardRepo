package com.standard.multiviewtyperecyclerview.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.standard.multiviewtyperecyclerview.databinding.ActivityDetailBinding
import com.standard.multiviewtyperecyclerview.extension.getParcelableExtra
import com.standard.multiviewtyperecyclerview.presentation.model.BlueCardModel

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val bludCardModel by getParcelableExtra<BlueCardModel>(EXTRA_CARD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.detailName.text = bludCardModel?.userName
        binding.detailCardNum.text = bludCardModel?.cardNumber
        binding.detailPeiod.text = bludCardModel?.period
        binding.detailViewType.text = bludCardModel?.cardViewType?.name
    }
}