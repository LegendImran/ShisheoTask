package com.example.shisheotask.database

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.shisheotask.R
import com.example.shisheotask.modal.RestaurentCard

class AppRepository(var application: Application) {

    var images :ArrayList<Int> = ArrayList()
    var rates : ArrayList<Int> = ArrayList()
    var dishnames:Array<String>? = null
    var cuisine:Array<String>? = null
    var prices:Array<String>? = null
    var discounts:Array<String>? = null
    var deliverTimes:Array<String>? = null
    var paymentStatus:Array<String>? = null

    init {
        images.add(R.drawable.ic_demo_dish)
        images.add(R.drawable.ig_dish_2)
        images.add(R.drawable.ig_dish_3)

        rates.add(5)
        rates.add(3)
        rates.add(4)

        dishnames = application.resources.getStringArray(R.array.dishname)
        cuisine = application.resources.getStringArray(R.array.cuisine)
        prices = application.resources.getStringArray(R.array.cost)
        discounts = application.resources.getStringArray(R.array.sale)
        deliverTimes = application.resources.getStringArray(R.array.delivery_time)
        paymentStatus = application.resources.getStringArray(R.array.payment_status)

    }


    val TAG = AppRepository::class.java.canonicalName

    private var post: ArrayList<RestaurentCard> = ArrayList()
    private var mutableLiveData: MutableLiveData<List<RestaurentCard>> =
        MutableLiveData<List<RestaurentCard>>()

    fun getCardListMutableLivedata():ArrayList<RestaurentCard>{

        for(i in 0..(images.size-1)){
            post.add(RestaurentCard(images.get(i),dishnames!![i],cuisine!![i],prices!![i],discounts!![i],rates.get(i),deliverTimes!![i],paymentStatus!![i]))
        }

        val livePost = MutableLiveData<ArrayList<RestaurentCard>>()
        livePost.value = arrayListOf();
        livePost.postValue(post);
        return post;

    }
}