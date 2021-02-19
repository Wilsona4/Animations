package com.funcrib.animations.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.funcrib.animations.Model.GunnerModel
import com.funcrib.animations.R
import com.funcrib.animations.ViewPagerAdapter
import com.funcrib.animations.transformers.*
import kotlinx.android.synthetic.main.activity_gunners.*

class GunnersActivity : AppCompatActivity() {
    var gunnerList = createGunnerList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gunners)

        val viewPager2: ViewPager2 = view_pager
        val adapter = ViewPagerAdapter(this.gunnerList)
        viewPager2.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_gunner, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val menuId = item.itemId

        when (menuId) {

            R.id.zoom_out -> setPageTransformer(ZoomOutTransformation())
            R.id.depth_page -> setPageTransformer(DepthPageTransformation())
            R.id.vertical_flip -> setPageTransformer(VerticalFlipTransformation())
            R.id.fade_out -> setPageTransformer(FadeOutTransformation())
            R.id.cube_out -> setPageTransformer(CubeOutDepthTransformation())
            R.id.hinge -> setPageTransformer(HingeTransformation())
        }

        return super.onOptionsItemSelected(item)
    }


    private fun setPageTransformer(transformer: ViewPager2.PageTransformer) {
        view_pager.setPageTransformer(transformer)
    }

    private fun createGunnerList(): List<GunnerModel> {
        val gunnersList = ArrayList<GunnerModel>()


        gunnersList.add(GunnerModel(R.drawable.lac_two))
        gunnersList.add(GunnerModel(R.drawable.mo))
        gunnersList.add(GunnerModel(R.drawable.partey))
        gunnersList.add(GunnerModel(R.drawable.laca))
        gunnersList.add(GunnerModel(R.drawable.nico))
        gunnersList.add(GunnerModel(R.drawable.icecold))
        gunnersList.add(GunnerModel(R.drawable.mesut))
        gunnersList.add(GunnerModel(R.drawable.teye))
        gunnersList.add(GunnerModel(R.drawable.saka))
        gunnersList.add(GunnerModel(R.drawable.reiss))
        gunnersList.add(GunnerModel(R.drawable.lac))
        gunnersList.add(GunnerModel(R.drawable.ozil))
        gunnersList.add(GunnerModel(R.drawable.kt))
        gunnersList.add(GunnerModel(R.drawable.gabi))
        gunnersList.add(GunnerModel(R.drawable.david))
        gunnersList.add(GunnerModel(R.drawable.bernd))

        return gunnersList
    }
}