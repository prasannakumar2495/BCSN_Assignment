package com.example.bcsnassignment.viewmodel

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bcsnassignment.view.SpotFragment
import com.example.bcsnassignment.view.ZoneFragment

class BCSNPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private var fragmentArrayList = arrayListOf<Fragment>()
    private var fragmentTitle = arrayListOf<String>()
    override fun getCount(): Int {
     //   return fragmentArrayList.size
        return 2
    }

    override fun getItem(position: Int): Fragment {
       // return fragmentArrayList[position]
        when (position) {
            0 -> return SpotFragment()
            1 -> return ZoneFragment()
        }
        // return null   : as we are not allowed to return "null", below line is added.
        throw IllegalStateException("position $position is invalid for this viewpager")
    }

    override fun getPageTitle(position: Int): CharSequence? {
     //   return fragmentTitle[position]
        when (position) {
            0 -> return "SPOT"
            1 -> return "ZONE"
        }
        return null
    }

/*
fun addFragment(fragment: Fragment, title: String) {
Log.d(
"SIZE: ",
fragmentArrayList.lastIndex.toString()
)
fragmentArrayList.add(fragment)
fragmentTitle.add(title)
}
*/
}