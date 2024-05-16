package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser

class GitHubUserSharedViewModel : ViewModel() {
    private val _favoriteLiveData = MutableLiveData<List<GitHubUser>>()
    val favoriteLiveData: LiveData<List<GitHubUser>> = _favoriteLiveData

    fun setFavoriteList(list: List<GitHubUser>) {
        _favoriteLiveData.value = list
    }
}


