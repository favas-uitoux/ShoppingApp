package com.project.shoppingapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.shoppingapp.R
import com.project.shoppingapp.Utils
import com.project.shoppingapp.database.entity.CategoryEntity


class AdapterProducts(
    private val context: Context,

    private val list: MutableList<CategoryEntity>,
    private val selected_category: String



) :
    RecyclerView.Adapter<AdapterProducts.VHClass>() {


    class VHClass(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val iv: ImageView = itemview.findViewById(R.id.iv)


        val txt: TextView = itemview.findViewById(R.id.txt)
        val txtPrice: TextView = itemview.findViewById(R.id.txtPrice)
        val card: CardView = itemview.findViewById(R.id.card)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHClass {

        val view = LayoutInflater.from(context).inflate(R.layout.model_product, parent, false)

        return VHClass(view)

    }

    override fun onBindViewHolder(holder: VHClass, position: Int) {

        val cpr = list[position]
        holder.txt.setText("" + cpr.title)
        holder.txtPrice.setText("" + cpr.price)


        var profilepic = cpr.imageUrl


        Glide.with(context).load(profilepic)
            .sizeMultiplier(.5f)
            .placeholder(R.drawable.blanc_pic)
            .error(R.drawable.blanc_pic)
            .fallback(R.drawable.blanc_pic)
            .dontAnimate()
            .into(holder.iv)



        holder.card.setOnClickListener {
            Utils.dashActivityInterface.show(selected_category,holder.txt.text.toString())

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


}