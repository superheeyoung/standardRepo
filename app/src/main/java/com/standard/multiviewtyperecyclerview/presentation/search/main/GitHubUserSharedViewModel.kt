package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserEntity

class GitHubUserSharedViewModel : ViewModel() {
    private val _favoriteLiveData = MutableLiveData<List<GitHubUserEntity>>()
    val favoriteLiveData: LiveData<List<GitHubUserEntity>> = _favoriteLiveData

    fun setFavoriteList(list: List<GitHubUserEntity>) {
        _favoriteLiveData.value = list
    }
}


