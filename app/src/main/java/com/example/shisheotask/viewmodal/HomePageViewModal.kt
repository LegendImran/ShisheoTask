package com.example.shisheotask.viewmodal

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shisheotask.database.AppRepository
import com.example.shisheotask.modal.RestaurentCard

/**
 * HomePageViewModal it interact with AppRepository and View
 */
public class HomePageViewModal (@NonNull application: Application) : AndroidViewModel(application) {

    private var postRepository: AppRepository? = null

    init {
        postRepository = AppRepository(application)
    }

    /**
     * getAllRestauRantCard
     * @return MutableLiveData is observed by View complete
     */
    fun getAllRestauRantCard() : MutableLiveData<ArrayList<RestaurentCard>>? {
        return postRepository?.getCardListMutableLivedata()
    }
}