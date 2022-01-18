package com.example.bcsnassignment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.bcsnassignment.R
import com.example.bcsnassignment.viewmodel.BCSNPagerAdapter
import com.google.android.material.tabs.TabLayout

const val baseURL = "https://www.binance.com/"

class Fragment_two : Fragment() {

    private lateinit var tabLayoutFragment: TabLayout
    private lateinit var vPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_two, container, false)
        addFragment(view)
        return view
    }

    /*
private fun addFragment(view: View) {
tabLayoutFragment = view.findViewById(R.id.tabLayout)
vPager = view.findViewById(R.id.viewPager)
val adapter = BCSNPagerAdapter(childFragmentManager)
adapter.addFragment(SpotFragment(), "SPOT")
adapter.addFragment(ZoneFragment(), "ZONE")
// vPager.offscreenPageLimit = 2
vPager.adapter
tabLayoutFragment.setupWithViewPager(vPager)
}
*/

    private fun addFragment(view: View) {
        tabLayoutFragment = view.findViewById(R.id.tabLayout)
        vPager = view.findViewById(R.id.viewPager)
        // val adapter = BCSNPagerAdapter(childFragmentManager)
//        adapter.addFragment(SpotFragment(), "SPOT")
//        adapter.addFragment(ZoneFragment(), "ZONE")
        // vPager.offscreenPageLimit = 2
        vPager.adapter = BCSNPagerAdapter(childFragmentManager)
        tabLayoutFragment.setupWithViewPager(vPager)
    }
}