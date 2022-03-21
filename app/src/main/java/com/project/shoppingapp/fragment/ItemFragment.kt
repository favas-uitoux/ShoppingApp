package com.project.shoppingapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.shoppingapp.R
import com.project.shoppingapp.Utils
import com.project.shoppingapp.adapter.AdapterCategory
import com.project.shoppingapp.database.entity.CategoryEntity
import com.project.shoppingapp.interfac.DashbordFragmentInterface
import com.project.shoppingapp.model.model1
import com.project.shoppingapp.viewmodel.CategoryViewModel
import java.lang.Exception

class ItemFragment : Fragment() {


    private lateinit var view1: View
    private lateinit var viewModel: CategoryViewModel
    private lateinit var iv: ImageView
    private lateinit var txtProduct: TextView
    private lateinit var txtPrice: TextView
    private lateinit var txtDescription: TextView
    private lateinit var txtAdd: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        view1 = inflater.inflate(R.layout.fragment_item, container, false)





        init()



        return view1


    }

    private fun init() {

        val bundle = arguments
        val category = bundle!!.getString("category")!!
        val product = bundle!!.getString("product")!!

        iv=view1.findViewById(R.id.iv)
        txtProduct=view1.findViewById(R.id.txtProduct)
        txtPrice=view1.findViewById(R.id.txtPrice)
        txtDescription=view1.findViewById(R.id.txtDescription)
        txtAdd=view1.findViewById(R.id.txtAdd)



        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        disply(category,product)
     Log.d("cat",""+category)
     Log.d("pro",""+product)



        txtAdd.setOnClickListener {
           Log.d("cnt---",""+viewModel.readSize())
        }


    }

    private fun disply(category:String,product:String)
    {
      var res=  viewModel.readDetailsOfAProduct(category,product)



        try {
            var profilepic=res.imageUrl

            Glide.with(context).load(profilepic)
                .sizeMultiplier(.5f)
                .placeholder(R.drawable.blanc_pic)
                .error(R.drawable.blanc_pic)
                .fallback(R.drawable.blanc_pic)
                .dontAnimate()
                .into(iv)


            txtProduct.text=res.title
            txtPrice.text=res.price.toString()
            txtDescription.text=res.description



        }
        catch (e:Exception)
        {}



    }








}