package com.example.pocket_manager_v2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.pocket_manager_v2.utils.PagerModel

class PocketManagerAdapter(private val context: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val page = PagerModel.values()[position]
        return context.getString(page.titleResId)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val page = PagerModel.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(page.layoutResId, container, false) as ViewGroup
        container.addView(layout)
        return layout

    }

    override fun getCount(): Int {
        return PagerModel.values().size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}