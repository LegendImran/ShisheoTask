package com.example.shisheotask.activities

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.shisheotask.R
import com.example.shisheotask.fragments.RestaurantListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        initView()

        displayRestaurentPage();

    }

    private fun initView(){
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }


    private fun displayRestaurentPage() {
        val restaurantListFragment = RestaurantListFragment()
        val bundle = Bundle()
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frame, restaurantListFragment)
        beginTransaction.commit()
    }

    fun navigateHomeTab(view: View) {
        displayRestaurentPage()
    }
    fun navigateMapTab(view: View) {

    }
}