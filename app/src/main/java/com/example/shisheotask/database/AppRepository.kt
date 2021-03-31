package com.example.shisheotask.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.shisheotask.R
import com.example.shisheotask.modal.RestaurentCard


/**
 * AppRepository is central data source of app
 * this class directly intract with database and remote Server
 */
class AppRepository(var application: Application) {

    var images: ArrayList<Int> = ArrayList()
    var rates: ArrayList<Int> = ArrayList()
    var dishnames: Array<String>? = null
    var cuisine: Array<String>? = null
    var prices: Array<String>? = null
    var discounts: Array<String>? = null
    var deliverTimes: Array<String>? = null
    var paymentStatus: Array<String>? = null

    /**
     * this for initialize data
     *
     */
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


    /**
     * getCardListMutableLivedata connect database and return Live Data
     * @return livePost is MutableLiveData is act like Observable it notify its Observer whenever there is change in data
     */
    fun getCardListMutableLivedata(): MutableLiveData<ArrayList<RestaurentCard>> {

        for (i in 0..(images.size - 1)) {
            post.add(
                RestaurentCard(
                    images.get(i),
                    dishnames!![i],
                    cuisine!![i],
                    prices!![i],
                    discounts!![i],
                    rates.get(i),
                    deliverTimes!![i],
                    paymentStatus!![i]
                )
            )
        }
        val livePost = MutableLiveData<ArrayList<RestaurentCard>>()
        livePost.value = arrayListOf();
        livePost.postValue(post);
        return livePost;

    }

    fun getFilterdRestaurent(searchString: String): MutableLiveData<ArrayList<RestaurentCard>> {
        post.clear()
        for (i in 0..(images.size - 1)) {
            Log.i(TAG,"")
            if (dishnames!![i].contains(searchString)) {
                post.add(
                    RestaurentCard(
                        images.get(i),
                        dishnames!![i],
                        cuisine!![i],
                        prices!![i],
                        discounts!![i],
                        rates.get(i),
                        deliverTimes!![i],
                        paymentStatus!![i]
                    )
                )
            }
        }
        val livePost = MutableLiveData<ArrayList<RestaurentCard>>()
        livePost.value = arrayListOf();
        livePost.postValue(post);
        return livePost;
    }

}