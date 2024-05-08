package com.standard.multiviewtyperecyclerview.presentation.main2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.standard.multiviewtyperecyclerview.R
import com.standard.multiviewtyperecyclerview.presentation.favorite.FavoriteListFragment
import com.standard.multiviewtyperecyclerview.presentation.search.main.GitHubUserFragment

class SearchMainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf(
        SearchMainTabModel(GitHubUserFragment.newInstance(), R.string.search_tab_search_title),
        SearchMainTabModel(FavoriteListFragment.newInstance(), R.string.search_tab_favorite_title),
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position].fragment

    fun getTitle(position: Int): Int = fragments[position].title
}