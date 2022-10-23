package com.aroman.testexcercise4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.aroman.testexcercise4.R
import com.aroman.testexcercise4.databinding.ActivityMainBinding
import com.aroman.testexcercise4.ui.classesFragment.ClassesFragment
import com.aroman.testexcercise4.ui.homeFragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragmentAdapter: FragmentAdapter =
        FragmentAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
        initViewPager()
    }

    private fun initBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> binding.pager.currentItem = 0
                R.id.action_classes -> binding.pager.currentItem = 1
            }
            true
        }
    }

    private fun initViewPager() {
        fragmentAdapter.apply {
            addFragment(HomeFragment())
            addFragment(ClassesFragment())
        }
        binding.pager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = fragmentAdapter
        }
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNavigation.selectedItemId = R.id.action_home
                    1 -> binding.bottomNavigation.selectedItemId = R.id.action_classes
                }
                super.onPageSelected(position)
            }
        })
    }
}