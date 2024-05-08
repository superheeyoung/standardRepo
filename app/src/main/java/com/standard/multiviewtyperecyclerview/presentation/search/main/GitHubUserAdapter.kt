package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.standard.multiviewtyperecyclerview.R
import com.standard.multiviewtyperecyclerview.databinding.ItemGithubUserBinding
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserEntity

//TODO abstract ViewHolder
class GitHubUserAdapter(
    private val onClick: (GitHubUserEntity) -> Unit
) :
    RecyclerView.Adapter<GitHubUserAdapter.GitHubUserViewHolder>() {
    var gitHubUserList = listOf<GitHubUserEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_github_user, parent, false)
        return GitHubUserViewHolder(ItemGithubUserBinding.bind(view), onClick)
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
    }

    override fun onBindViewHolder(holder: GitHubUserViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)

        holder.itemView.setOnClickListener {
            onClick(currentItem)
        }
    }

    class GitHubUserViewHolder(
        private val binding: ItemGithubUserBinding,
        private val onClick: (GitHubUserEntity) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gitHubUser: GitHubUserEntity) = with(binding) {
            switchFavorite.isChecked = gitHubUser.isFavorite
            tvUserName.text = gitHubUser.loginName
            imgUserAvatar.load(gitHubUser.avatarUrl)
            switchFavorite.setOnClickListener {
                if (gitHubUser.isFavorite != switchFavorite.isChecked) {
                    onClick(gitHubUser)
                }
            }
        }
    }
}