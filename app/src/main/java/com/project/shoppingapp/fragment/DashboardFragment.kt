package com.project.shoppingapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.shoppingapp.R
import com.project.shoppingapp.Utils
import com.project.shoppingapp.adapter.AdapterCategory
import com.project.shoppingapp.database.entity.CategoryEntity
import com.project.shoppingapp.interfac.DashbordFragmentInterface
import com.project.shoppingapp.model.model1
import com.project.shoppingapp.viewmodel.CategoryViewModel

class DashboardFragment : Fragment(), DashbordFragmentInterface {


    private lateinit var view1: View
    private lateinit var viewModel: CategoryViewModel

    //
    private lateinit var adp: AdapterCategory
    //private lateinit var adp2: AdapterProducts
    private lateinit var recv: RecyclerView
    private lateinit var list2:MutableList<CategoryEntity>

//    private lateinit var list:MutableList<EmployEntiity>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        view1 = inflater.inflate(R.layout.fragment_dashboard, container, false)

        Utils.dashInterface = this

        init()
        showCategory()


        return view1


    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        recv = view1.findViewById(R.id.recv)



        viewModel.readLiveSize().observe(viewLifecycleOwner, Observer {

            val list = mutableListOf<model1>()
            var listSpecificProducts = mutableListOf<CategoryEntity>()

            recv.adapter = null



            var flag = false

            for (row: String in viewModel.showSavedCategoryNames()) {


                list.add(model1(row, flag))
            }
            recv.layoutManager = LinearLayoutManager(activity)
            recv.adapter = AdapterCategory(requireActivity(), list, listSpecificProducts,viewModel)

        })



    }


    private fun showCategory() {





        val list = mutableListOf<model1>()
        var listSpecificProducts = mutableListOf<CategoryEntity>()

        recv.adapter = null



        var flag = false

        for (row: String in viewModel.readAllCategoryNames()) {


            list.add(model1(row, flag))
        }


        recv.layoutManager = LinearLayoutManager(activity)
        recv.adapter = AdapterCategory(requireActivity(), list, listSpecificProducts,viewModel)


    }

    override fun show(category: String) {

        val list = mutableListOf<model1>()

        val listSpecificProducts = mutableListOf<CategoryEntity>()

        recv.adapter = null
        //  val list = mutableListOf<String>()


        var flag = false

        for (row: String in viewModel.readAllCategoryNames()) {


            if (category.equals(row)) {


                listSpecificProducts.addAll(viewModel.readSpecificProducts(row))



                flag = true
            } else {
                flag = false
            }

            list.add(model1(row, flag))
        }


        recv.layoutManager = LinearLayoutManager(activity)
        recv.adapter = AdapterCategory(requireActivity(), list, listSpecificProducts,viewModel)


    }


}