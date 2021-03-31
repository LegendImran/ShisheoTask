package com.example.shisheotask.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shisheotask.R
import com.example.shisheotask.adapter.RestaurantRecyclerAdapter
import com.example.shisheotask.modal.RestaurentCard
import com.example.shisheotask.viewmodal.HomePageViewModal
import com.example.shisheotask.viewmodal.HomePageViewModelFactory


/**
 * RestaurantListFragment Fragment for showing List of Restaurant
 *
 */
class RestaurantListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var  mViewModel: HomePageViewModal
    var adapter : RestaurantRecyclerAdapter? = null

    lateinit var search:EditText;

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


    /**
     * initView for initlize View
     * @param view to get reference on View Componant
     * @see homePageViewModelFactory is used to initialize HomePageViewModal
     *
     */
    private fun initView(view: View){
        recyclerView = view.findViewById(R.id.recycle_restaurant)
        search = view.findViewById(R.id.searchRest)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        var homePageViewModelFactory = HomePageViewModelFactory(activity?.application!!);
        mViewModel = ViewModelProvider(this, homePageViewModelFactory).get(HomePageViewModal::class.java)
        mViewModel.getAllRestauRantCard()?.observe(this, Observer { t ->
            addRestaurantDataInAdapter(t)
        })

        search.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mViewModel.getFilterdRestaurent(p0.toString())?.observe(this@RestaurantListFragment, Observer { t ->
                    addRestaurantDataInAdapter(t)
                })
            }
        })
    }

    /**
     * addRestaurantDataInAdapter for set data in adapteer
     * @param list used to fill data in recyclerView adapter
     */
    private fun addRestaurantDataInAdapter(list: ArrayList<RestaurentCard>){
        adapter = RestaurantRecyclerAdapter(context!!,list);
        recyclerView.adapter = adapter;
        adapter?.notifyDataSetChanged()
    }

}