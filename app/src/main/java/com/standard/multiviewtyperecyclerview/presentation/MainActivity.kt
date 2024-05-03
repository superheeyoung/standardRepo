package com.standard.multiviewtyperecyclerview.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.multiviewtyperecyclerview.data.database.DataSource
import com.standard.multiviewtyperecyclerview.data.database.Card
import com.standard.multiviewtyperecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //TODO : editText에서 받아온 data 파라메터로 넣기
        mainViewModel.getSearchImageList("cindy")


        mainViewModel.getSearchImageLiveData.observe(this@MainActivity) {
            //TODO setting RecyclerView
            Log.d("debugSearchData", it.toString())
        }
    }
}