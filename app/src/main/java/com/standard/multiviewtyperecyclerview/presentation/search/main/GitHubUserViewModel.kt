package com.standard.multiviewtyperecyclerview.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.asFavoriteUserEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.repository.CacheRepository
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Inject constructor -> 생성자에 주입, 생성자에 힐트가 인스턴스 제공
@HiltViewModel
class GitHubUserViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val cacheRepository: CacheRepository
) : ViewModel() {

    private val _getGitHubUserList: MutableLiveData<List<GitHubUser>> = MutableLiveData()
    val getGitHubUserList: LiveData<List<GitHubUser>> get() = _getGitHubUserList

    private val _favoriteUserList: MutableLiveData<List<GitHubUser>> = MutableLiveData()
    val favoriteUserList: LiveData<List<GitHubUser>> get() = _favoriteUserList



    fun getGitHubUserList() {
        viewModelScope.launch {
            _getGitHubUserList.value = searchRepository.getGitHubUserList("cindy").items
        }
    }

    //TODO room
    fun insertGitHubUser(gitHubUser: GitHubUser) {
        viewModelScope.launch {
            cacheRepository.insertGitHubUserList(gitHubUser.asFavoriteUserEntity())
        }
    }

    fun setFavoriteItem(item: GitHubUser) {
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

/*
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
}*/
