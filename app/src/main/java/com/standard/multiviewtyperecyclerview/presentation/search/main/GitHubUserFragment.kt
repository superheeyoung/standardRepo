package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.multiviewtyperecyclerview.databinding.FragmentGithubSearchUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GitHubUserFragment : Fragment() {
    companion object {
        fun newInstance() = GitHubUserFragment()
    }

    private var _binding: FragmentGithubSearchUsersBinding? = null
    private val binding get() = _binding!!

    private val gitHubUserViewModel: GitHubUserViewModel by lazy {
        ViewModelProvider(requireActivity())[GitHubUserViewModel::class.java]
    }

    private val gitHubUserPagingAdapter = GitHubUserPagingAdapter {
        gitHubUserViewModel.setFavoriteUser(it)
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
        binding.rvGithubUsers.adapter = gitHubUserPagingAdapter

        binding.etSearch.doAfterTextChanged {
            gitHubUserViewModel.setUserName(binding.etSearch.text.trim().toString())
        }
    }

    private fun initViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            gitHubUserViewModel.pagingDataFlow.collectLatest {
                gitHubUserPagingAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}