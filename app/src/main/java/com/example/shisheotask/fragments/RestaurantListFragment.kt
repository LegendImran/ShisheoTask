package com.example.shisheotask.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shisheotask.R
import com.example.shisheotask.activities.MainActivity
import com.example.shisheotask.adapter.RestaurantRecyclerAdapter
import com.example.shisheotask.database.AppRepository
import com.example.shisheotask.modal.RestaurentCard
import com.example.shisheotask.viewmodal.HomePageViewModal
import com.example.shisheotask.viewmodal.HomePageViewModelFactory

class RestaurantListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    lateinit var  mViewModel: HomePageViewModal
    var adapter : RestaurantRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }


    private fun initView(view: View){
        recyclerView = view.findViewById(R.id.recycle_restaurant)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        var homePageViewModelFactory = HomePageViewModelFactory(activity?.application!!);
        mViewModel = ViewModelProvider(this, homePageViewModelFactory).get(HomePageViewModal::class.java)
        mViewModel.getAllRestauRantCard()?.observe(this, Observer { t ->
            addValueInAdapter(t)
        })
    }

    private fun addValueInAdapter(list: ArrayList<RestaurentCard>){
        adapter = RestaurantRecyclerAdapter(context!!,list);
        recyclerView.adapter = adapter;
        adapter?.notifyDataSetChanged()
    }

}