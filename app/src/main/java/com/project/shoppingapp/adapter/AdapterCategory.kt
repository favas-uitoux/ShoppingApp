package com.project.shoppingapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.shoppingapp.R
import com.project.shoppingapp.Utils
import com.project.shoppingapp.database.entity.CategoryEntity
import com.project.shoppingapp.model.model1
import com.project.shoppingapp.viewmodel.CategoryViewModel


class AdapterCategory(
    private val context: Context,
    private var list: MutableList<model1>,
    private var listSpecificProducts: MutableList<CategoryEntity>,
    private val viewModel: CategoryViewModel,



) :
    RecyclerView.Adapter<AdapterCategory.VHClass>() {


    class VHClass(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val txtCategory: TextView = itemview.findViewById(R.id.txtCategory)

        val recvProducts: RecyclerView = itemview.findViewById(R.id.recvProducts)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHClass {

        val view = LayoutInflater.from(context).inflate(R.layout.model_row, parent, false)

        return VHClass(view)

    }

    override fun onBindViewHolder(holder: VHClass, position: Int) {

        val cpr = list[position]
        holder.txtCategory.setText("" + cpr.title)

        if (cpr.show) {


            holder.recvProducts.visibility = View.VISIBLE

            holder.recvProducts.setLayoutManager(GridLayoutManager(context, 2))
            holder.recvProducts.adapter = AdapterProducts(context, listSpecificProducts,holder.txtCategory.text.toString())
//


        } else {
            holder.recvProducts.visibility = View.GONE

        }


        holder.txtCategory.setOnClickListener {


            reset()
            listSpecificProducts = mutableListOf<CategoryEntity>()


            for (row: String in viewModel.readAllCategoryNames()) {


                if (holder.txtCategory.text.toString().equals(row)) {

                    listSpecificProducts.addAll(viewModel.readSpecificProducts(row))

                    if(!Utils.previouslySelected .equals(holder.txtCategory.text.toString())  )
                    {
                        list[position].show = true
                        Utils.previouslySelected=holder.txtCategory.text.toString()
                    }


                }

            }

            notifyDataSetChanged()


            //  Utils.dashInterface.show(holder.txtCategory.text.toString())


        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun reset() {
        for (i in 0 until list.size) {
            list[i].show = false
        }

    }


}