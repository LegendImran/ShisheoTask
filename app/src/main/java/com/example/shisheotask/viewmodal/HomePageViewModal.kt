package com.example.shisheotask.viewmodal

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shisheotask.database.AppRepository
import com.example.shisheotask.modal.RestaurentCard

public class HomePageViewModal (@NonNull application: Application) : AndroidViewModel(application) {

    private var postRepository: AppRepository? = null

    init {
        postRepository = AppRepository(application)
    }

    fun getAllRestauRantCard() : MutableLiveData<ArrayList<RestaurentCard>>? {
        return postRepository?.getCardListMutableLivedata()
    }
}