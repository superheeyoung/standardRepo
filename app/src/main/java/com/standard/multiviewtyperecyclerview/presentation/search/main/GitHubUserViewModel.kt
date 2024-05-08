package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.standard.multiviewtyperecyclerview.data.database.DataSource
import com.standard.multiviewtyperecyclerview.data.remote.repository.SearchRepositoryImpl
import com.standard.multiviewtyperecyclerview.network.RetrofitClient
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserEntity
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import kotlinx.coroutines.launch

class GitHubUserViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _getGitHubUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val getGitHubUserList: LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList

    private val _favoriteUserList: MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val favoriteUserList: LiveData<List<GitHubUserEntity>> get() = _favoriteUserList

    fun getGitHubUserList() {
        viewModelScope.launch {
            _getGitHubUserList.value = searchRepository.getGitHubUserList("cindy").items
        }
    }

    fun setFavoriteItem(item: GitHubUserEntity) {
        val gitHubUserList = _getGitHubUserList.value!!.toMutableList()
        val position = gitHubUserList.indexOfFirst {
            it.id == item.id
        }
        //TODO !! 연산자 개선하기
        _getGitHubUserList.value =
            gitHubUserList.also {
                it[position] = item.copy(
                    isFavorite = item.isFavorite.not()
                )
            }

        _favoriteUserList.value = gitHubUserList.filter {
            it.isFavorite
        }
    }
}

class GitHubUserViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(DataSource, RetrofitClient.searchGitHubUser)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return GitHubUserViewModel(
            repository
        ) as T
    }
}