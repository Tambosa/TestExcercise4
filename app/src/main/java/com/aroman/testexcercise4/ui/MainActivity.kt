package com.aroman.testexcercise4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
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

        fragmentAdapter.addFragment(HomeFragment())
        fragmentAdapter.addFragment(ClassesFragment())

        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.pager.adapter = fragmentAdapter
    }
}