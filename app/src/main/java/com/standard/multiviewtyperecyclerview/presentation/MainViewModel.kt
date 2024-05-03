package com.standard.multiviewtyperecyclerview.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.standard.multiviewtyperecyclerview.data.remote.SearchRemoteDataSource
import com.standard.multiviewtyperecyclerview.data.remote.model.DocumentResponse
import com.standard.multiviewtyperecyclerview.data.remote.model.SearchResponse
import com.standard.multiviewtyperecyclerview.network.RetrofitClient
import kotlinx.coroutines.launch

class MainViewModel(private val remoteDataSource: SearchRemoteDataSource) : ViewModel() {
    private val _getSearchImageLiveData : MutableLiveData<List<DocumentResponse>> = MutableLiveData()
    val getSearchImageLiveData : LiveData<List<DocumentResponse>> get() = _getSearchImageLiveData

    fun getSearchImageList(query : String) = viewModelScope.launch {
        _getSearchImageLiveData.value = remoteDataSource.getSearch(query).searchDocuments
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return MainViewModel(
            RetrofitClient.searchRemoteDataSource
        ) as T
    }
}