package com.example.shisheotask.viewmodal

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class HomePageViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomePageViewModal::class.java)) {
            return HomePageViewModal(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")    }
}