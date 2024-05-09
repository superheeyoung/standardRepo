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
        //toMutableList 수정가능 한 List로 변경
        val gitHubUserList = _getGitHubUserList.value!!.toMutableList()

        //매칭된 아이템의 index를 반환
        val position = gitHubUserList.indexOfFirst {
            it.id == item.id
        }
        //TODO !! 연산자 개선하기
        _getGitHubUserList.value =
            //livedata에서 받아온 list를 index으로 sorting해서 data class copy함 (data class의 객체를 복사)
            gitHubUserList.also {
                it[position] = item.copy(
                    //bool 값을 반대값 세팅
                    isFavorite = !item.isFavorite
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