package com.standard.multiviewtyperecyclerview.presentation.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.standard.multiviewtyperecyclerview.R
import com.standard.multiviewtyperecyclerview.databinding.ItemGithubUserBinding
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser

class FavoriteListAdapter :
    RecyclerView.Adapter<FavoriteListAdapter.FavoriteUserViewHolder>() {
    var gitHubUserList = listOf<GitHubUser>()

    class FavoriteUserViewHolder(private val binding: ItemGithubUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gitHubUser: GitHubUser) {
            with(binding) {
                switchFavorite.isChecked = gitHubUser.isFavorite
                tvUserName.text = gitHubUser.loginName
                imgUserAvatar.load(gitHubUser.avatarUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_github_user, parent, false)
        return FavoriteUserViewHolder(ItemGithubUserBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
    }

    override fun onBindViewHolder(holder: FavoriteUserViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)
    }
}