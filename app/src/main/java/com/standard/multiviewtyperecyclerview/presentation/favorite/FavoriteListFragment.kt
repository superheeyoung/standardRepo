package com.standard.multiviewtyperecyclerview.presentation.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.standard.multiviewtyperecyclerview.databinding.FragmentGithubFavoriteUsersBinding
import com.standard.multiviewtyperecyclerview.presentation.search.main.GitHubUserSharedViewModel
import com.standard.multiviewtyperecyclerview.presentation.search.main.GitHubUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteListFragment : Fragment() {
    companion object {
        fun newInstance() = FavoriteListFragment()
    }


    private var _binding: FragmentGithubFavoriteUsersBinding? = null
    private val binding get() = _binding!!

    private val gitHubUserViewModel: GitHubUserViewModel by lazy {
        ViewModelProvider(requireActivity())[GitHubUserViewModel::class.java]
    }

    private val favoriteListAdapter: FavoriteListAdapter by lazy {
        FavoriteListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGithubFavoriteUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            gitHubUserViewModel.favoriteUserFlow.collectLatest {
                favoriteListAdapter.gitHubUserList = it
                binding.rvGithubUsers.adapter = favoriteListAdapter
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}