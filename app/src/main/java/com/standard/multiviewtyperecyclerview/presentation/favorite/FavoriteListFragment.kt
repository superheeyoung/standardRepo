package com.standard.multiviewtyperecyclerview.presentation.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.standard.multiviewtyperecyclerview.databinding.FragmentGithubFavoriteUsersBinding
import com.standard.multiviewtyperecyclerview.presentation.search.main.GitHubUserSharedViewModel

class FavoriteListFragment : Fragment() {
    companion object {
        fun newInstance() = FavoriteListFragment()
    }


    private var _binding: FragmentGithubFavoriteUsersBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: GitHubUserSharedViewModel by lazy {
        ViewModelProvider(requireActivity())[GitHubUserSharedViewModel::class.java]
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
        initView()
        initViewModel()
    }

    private fun initView() = with(binding) {

    }

    private fun initViewModel() {
        sharedViewModel.favoriteLiveData.observe(viewLifecycleOwner) {
            Log.d("debug34343",it.toString())
            /*
            *    gitHubUserAdapter.gitHubUserList = it
            with(binding.rvGithubUsers) {
                adapter = gitHubUserAdapter
            }
            *
            *
            * */
            favoriteListAdapter.gitHubUserList = it
            binding.rvGithubUsers.adapter = favoriteListAdapter

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}