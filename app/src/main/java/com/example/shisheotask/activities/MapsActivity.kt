package com.example.shisheotask.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shisheotask.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        supportActionBar?.hide()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

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
    }
}