package com.aroman.testexcercise4.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList = mutableListOf<Fragment>()

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}