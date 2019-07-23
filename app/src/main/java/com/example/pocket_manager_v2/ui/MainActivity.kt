package com.example.pocket_manager_v2.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.pocket_manager_v2.R
import com.example.pocket_manager_v2.adapters.PocketManagerAdapter
import com.example.pocket_manager_v2.viewModels.ExpenseViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var modelViewModel: ExpenseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.string_transactions)))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.string_overview)))

        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = PocketManagerAdapter(this)
        viewPager!!.adapter=adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewPager!!.currentItem = p0!!.position
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

        })

        modelViewModel = ViewModelProviders.of(this).get(ExpenseViewModel::class.java)
    }
}
