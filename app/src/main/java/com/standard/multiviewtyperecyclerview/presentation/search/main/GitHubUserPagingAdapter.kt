package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.standard.multiviewtyperecyclerview.R
import com.standard.multiviewtyperecyclerview.databinding.ItemGithubUserBinding
import com.standard.multiviewtyperecyclerview.presentation.search.main.GitHubUserPagingAdapter.GitHubUserViewHolder.Companion.diffUtil
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser

class GitHubUserPagingAdapter(private val onClick: (GitHubUser) -> Unit) :
    PagingDataAdapter<GitHubUser, GitHubUserPagingAdapter.GitHubUserViewHolder>(diffUtil) {

    class GitHubUserViewHolder(
        private val binding: ItemGithubUserBinding,
        private val onClick: (GitHubUser) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gitHubUser: GitHubUser) = with(binding) {

            switchFavorite.isChecked = gitHubUser.isFavorite
            tvUserName.text = gitHubUser.loginName
            imgUserAvatar.load(gitHubUser.avatarUrl)
            switchFavorite.setOnClickListener {
                if (gitHubUser.isFavorite != switchFavorite.isChecked) {
                    onClick(gitHubUser)
                }
            }
        }

        companion object {
            val diffUtil = object : DiffUtil.ItemCallback<GitHubUser>() {
                override fun areItemsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
                    return oldItem == newItem
                }

            }
        }
    }

    override fun onBindViewHolder(holder: GitHubUserViewHolder, position: Int) {
        val item = getItem(position)!!
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_github_user, parent, false)
        return GitHubUserPagingAdapter.GitHubUserViewHolder(
            ItemGithubUserBinding.bind(view),
            onClick
        )
    }
}