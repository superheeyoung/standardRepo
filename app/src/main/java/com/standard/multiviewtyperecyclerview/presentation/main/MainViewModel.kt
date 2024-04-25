package com.standard.multiviewtyperecyclerview.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.standard.multiviewtyperecyclerview.data.database.DataSource
import com.standard.multiviewtyperecyclerview.data.repository.SearchRepositoryImpl
import com.standard.multiviewtyperecyclerview.presentation.model.BlueCardModel
import com.standard.multiviewtyperecyclerview.presentation.repository.SearchRepository

class MainViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _getBlueCardModel : MutableLiveData<List<BlueCardModel>> = MutableLiveData()
    val getBlueCardModel : LiveData<List<BlueCardModel>> get() = _getBlueCardModel

    fun getBlueCardModel() {
        _getBlueCardModel.value = searchRepository.getCardList()
    }
}
class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return MainViewModel(
            SearchRepositoryImpl(DataSource)
        ) as T
    }
}