package com.example.shisheotask.activities

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.shisheotask.R
import com.example.shisheotask.fragments.MapFragment
import com.example.shisheotask.fragments.RestaurantListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        supportActionBar?.hide()

        initView()

        displayRestaurentPage();

    }

    /**
     * this function in used to intilize view
     */
    private fun initView(){
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }


    /**
     * this function is used to showing Restaurant List
     */
    private fun displayRestaurentPage() {
        val restaurantListFragment = RestaurantListFragment()
        val bundle = Bundle()
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frame, restaurantListFragment)
        beginTransaction.commit()
    }

    /**
     * this function is used to showing Map Page
     */
    private fun displayMapPage() {
        val restaurantListFragment = MapFragment()
        val bundle = Bundle()
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frame, restaurantListFragment)
        beginTransaction.commit()
    }

    /**
     * this function invoke while clicking Home Tab
     * @param  view  view provided by os while click
     */
    fun navigateHomeTab(view: View) {
        displayRestaurentPage()
    }

    /**
     * this function invoke while clicking Location Tab
     * @param  view  view provided by os while click
     */
    fun navigateMapTab(view: View) {
        displayMapPage()
    }
}