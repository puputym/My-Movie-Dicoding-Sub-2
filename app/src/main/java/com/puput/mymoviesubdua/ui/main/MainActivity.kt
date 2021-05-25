package com.puput.mymoviesubdua.ui.main

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.puput.mymoviesubdua.R
import com.puput.mymoviesubdua.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val setViewPager = SectionPageAdapter(this)

        val viewPager: ViewPager2 = this.binding.viewPager
        viewPager.adapter = setViewPager
        val tabs: TabLayout = binding.tabLayout
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            this.run {
                tab.text = resources.getString(TAB_TITLES[position])
            }
        }.attach()

    }
}