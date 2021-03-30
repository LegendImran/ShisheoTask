package com.example.shisheotask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.shisheotask.R
import com.example.shisheotask.modal.RestaurentCard

class RestaurantRecyclerAdapter(var context:Context, var cards: List<RestaurentCard>) : RecyclerView.Adapter<RestaurantRecyclerAdapter.RviewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RviewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.restaurent_card,parent,false)
    )
    override fun getItemCount():  Int{
        if(cards != null && cards?.size!! > 0)
            return cards?.size!!
        else
            return 0
    }

    override fun onBindViewHolder(holder: RestaurantRecyclerAdapter.RviewHolder, position: Int) {
        holder.roundedImageView.setImageResource(cards.get(position).image)
        holder.dish_name.text = cards.get(position).dishName
        holder.cuisine.text = cards.get(position).cuisine
        holder.price.text = cards.get(position).price
        holder.discount_text.text = cards.get(position).discount
        holder.delivery_time.text = cards.get(position).deliveryTime
        holder.payment_type.text = cards.get(position).paymentStatus
        holder.rating.numStars = cards.get(position).rating

    }

    class RviewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var roundedImageView: ImageView = itemView.findViewById(R.id.roundedImageView)
        var dish_name: TextView = itemView.findViewById(R.id.dish_name)
        var cuisine: TextView = itemView.findViewById(R.id.cuisine)
        var price: TextView = itemView.findViewById(R.id.price)
        var discount_text: TextView = itemView.findViewById(R.id.discount_text)
        var rating: RatingBar = itemView.findViewById(R.id.rating)
        var delivery_time: TextView = itemView.findViewById(R.id.delivery_time)
        var payment_type: TextView = itemView.findViewById(R.id.payment_type)

    }

}