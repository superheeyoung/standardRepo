package com.standard.multiviewtyperecyclerview.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.standard.multiviewtyperecyclerview.databinding.SearchMainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

//Hilt 컴포넌트를 생성 - View(Activity, Fragment), Service, BroadcastReceiver
@AndroidEntryPoint
class SearchMainActivity : AppCompatActivity() {
    private val binding: SearchMainActivityBinding by lazy {
        SearchMainActivityBinding.inflate(layoutInflater)
    }

    private val viewPagerAdapter by lazy {
        SearchMainViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        viewPager.adapter = viewPagerAdapter
        //viewPager에 화면 수 세팅
        viewPager.offscreenPageLimit = viewPagerAdapter.itemCount

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()
    }

}