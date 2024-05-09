package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.multiviewtyperecyclerview.databinding.FragmentGithubSearchUsersBinding

class GitHubUserFragment : Fragment() {
    companion object {
        fun newInstance() = GitHubUserFragment()
    }

    private var _binding: FragmentGithubSearchUsersBinding? = null
    private val binding get() = _binding!!

    private val gitHubUserViewModel: GitHubUserViewModel by viewModels {
        GitHubUserViewModelFactory()
    }

    //TODO activityViewModels 확인
    //activityViewModels() 사용 시 Activity의 라이프사이클에 의해 생존주기 결정되며 액티비티내에서 같은 데이터 공유
    private val sharedViewModel : GitHubUserSharedViewModel by activityViewModels()

    private val gitHubUserAdapter: GitHubUserAdapter by lazy {
        GitHubUserAdapter {
            gitHubUserViewModel.setFavoriteItem(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGithubSearchUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() = with(binding) {
        btnSearch.setOnClickListener {
            gitHubUserViewModel.getGitHubUserList()
        }
    }

    private fun initViewModel() {
        gitHubUserViewModel.getGitHubUserList.observe(viewLifecycleOwner) {
            gitHubUserAdapter.gitHubUserList = it
            with(binding.rvGithubUsers) {
                adapter = gitHubUserAdapter
            }
        }

        gitHubUserViewModel.favoriteUserList.observe(viewLifecycleOwner) {
            sharedViewModel.setFavoriteList(it)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}