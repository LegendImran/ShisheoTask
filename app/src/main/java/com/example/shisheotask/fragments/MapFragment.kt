package com.example.shisheotask.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shisheotask.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


/**
 * MapFragment for showing Map in app
 */
class MapFragment : Fragment(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap
    lateinit var mapView: MapView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("TAG"," onCreateView: ")

        var view:View = inflater.inflate(R.layout.activity_maps,container,false)

        mapView = view.findViewById<MapView>(R.id.map)
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return view
    }





    override fun onPause() {
        super.onPause()
        if (this.mapView != null) this.mapView!!.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    /**
     * Override Method onMapReady it invoke after map is ready for shwing
     * @param googleMap using googlee map we can add maeker polyline in map
     */
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
        val restaurant4 = LatLng(25.172726, 55.248527)
        mMap.addMarker(MarkerOptions().position(burjkhalifa).title("Marker in Burj khalifa"))
        mMap.addMarker(MarkerOptions().position(restaurant1).title("Marker in Restarant1"))
        mMap.addMarker(MarkerOptions().position(restaurant2).title("Marker in Restarant2"))
        mMap.addMarker(MarkerOptions().position(restaurant3).title("Marker in Restarant3"))
        mMap.addMarker(MarkerOptions().position(restaurant4).title("Marker in Restarant3"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(burjkhalifa))
    }

}