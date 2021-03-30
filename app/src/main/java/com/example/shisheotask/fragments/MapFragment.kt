package com.example.shisheotask.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.shisheotask.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(){


    private lateinit var mMap: GoogleMap
      var mapFragment : SupportMapFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("TAG"," onCreateView: ")

        mapFragment =(activity as FragmentActivity).supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(object: OnMapReadyCallback{
            override fun onMapReady(googleMap: GoogleMap?) {
                Log.i("TAG"," ::onMapReady Called ")
                mMap = googleMap!!

                mMap.setMinZoomPreference(12.0f)
                mMap.setMaxZoomPreference(40.0f)
                // Add a marker in Sydney and move the camera
                val burjkhalifa = LatLng(25.1972, 55.2744)
                val restaurant1 = LatLng(25.192433, 55.250124)
                val restaurant2 = LatLng(25.184666, 55.231585)
                val restaurant3 = LatLng(25.162726, 55.258527)
                mMap.addMarker(MarkerOptions().position(burjkhalifa).title("Marker in Burj khalifa"))
                mMap.addMarker(MarkerOptions().position(restaurant1).title("Marker in Restarant1"))
                mMap.addMarker(MarkerOptions().position(restaurant2).title("Marker in Restarant2"))
                mMap.addMarker(MarkerOptions().position(restaurant3).title("Marker in Restarant3"))

                mMap.moveCamera(CameraUpdateFactory.newLatLng(burjkhalifa))            }

        })

        return inflater.inflate(R.layout.activity_maps,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("TAG"," onViewCreated: ")


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.i("TAG"," onActivityCreated: ")
        //mapFragment?.getMapAsync(this)
    }

    /*override fun onMapReady(googleMap: GoogleMap?) {

        Log.i("TAG"," ::onMapReady Called ")
        mMap = googleMap!!

        mMap.setMinZoomPreference(12.0f)
        mMap.setMaxZoomPreference(40.0f)
        // Add a marker in Sydney and move the camera
        val burjkhalifa = LatLng(25.1972, 55.2744)
        val restaurant1 = LatLng(25.192433, 55.250124)
        val restaurant2 = LatLng(25.184666, 55.231585)
        val restaurant3 = LatLng(25.162726, 55.258527)
        mMap.addMarker(MarkerOptions().position(burjkhalifa).title("Marker in Burj khalifa"))
        mMap.addMarker(MarkerOptions().position(restaurant1).title("Marker in Restarant1"))
        mMap.addMarker(MarkerOptions().position(restaurant2).title("Marker in Restarant2"))
        mMap.addMarker(MarkerOptions().position(restaurant3).title("Marker in Restarant3"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(burjkhalifa))
    }*/

    override fun onPause() {
        super.onPause()
        if (this.mapFragment != null) this.mapFragment!!.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapFragment?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapFragment?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapFragment?.onLowMemory()
    }

}