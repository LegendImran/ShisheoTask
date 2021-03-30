package com.example.shisheotask.modal


/**
 * RestaurentCard data class for Restaurant information
 */
data class RestaurentCard(val image:Int,val dishName:String, val cuisine:String,
                          val price:String,val discount:String,val rating:Int,
                          val deliveryTime:String, val paymentStatus :String)