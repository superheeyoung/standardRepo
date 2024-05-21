package com.standard.multiviewtyperecyclerview.presentation.search.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.asFavoriteUserEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.repository.CacheRepository
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

//Inject constructor -> 생성자에 주입, 생성자에 힐트가 인스턴스 제공
@HiltViewModel
class GitHubUserViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val cacheRepository: CacheRepository
) : ViewModel() {
    val favortieUser = mutableSetOf<GitHubUser>()

    private val _favoriteUserFlow = MutableSharedFlow<List<GitHubUser>>(replay = 1)
    val favoriteUserFlow = _favoriteUserFlow.asSharedFlow()

    private val _usersFlow = MutableStateFlow<List<GitHubUser>>(emptyList())
    val usersFlow: StateFlow<List<GitHubUser>> = _usersFlow.asStateFlow()

    private val queryFlow = MutableSharedFlow<String>()

    val pagingDataFlow = queryFlow.flatMapLatest {
        //searchRepository.getPagingGitHubUserList(it)
        searchRepository.getGitHubUserLists(it)
    }.cachedIn(viewModelScope)



    fun setUserName(userName: String) {
        viewModelScope.launch {
            queryFlow.emit(userName)
        }
    }

    fun setFavoriteUser(user: GitHubUser) {
        favortieUser.add(user)

        viewModelScope.launch {
            _favoriteUserFlow.emit(favortieUser.toList())
        }
    }

    fun getUserList() {
        viewModelScope.launch {
            val data = searchRepository.getGitHubUserLists(userName = "cindy")
        }
    }

    //TODO room
    fun insertGitHubUser(gitHubUser: GitHubUser) {
        viewModelScope.launch {
            cacheRepository.insertGitHubUserList(gitHubUser.asFavoriteUserEntity())
        }
    }
}
