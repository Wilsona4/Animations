package com.funcrib.animations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.funcrib.animations.Model.GunnerModel
import kotlinx.android.synthetic.main.viewpager_list.view.*


class ViewPagerAdapter(private val gunnerList: List<GunnerModel>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    class ViewPagerHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.viewpager_list, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.view.apply {
            iv_arsenal.setImageResource(gunnerList[position].image)
        }
    }

    override fun getItemCount(): Int {
        return gunnerList.size
    }


}