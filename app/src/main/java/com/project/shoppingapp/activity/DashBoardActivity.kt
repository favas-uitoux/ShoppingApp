package com.project.shoppingapp.activity

import android.os.Bundle
import com.project.shoppingapp.R
import com.project.shoppingapp.Utils
import com.project.shoppingapp.fragment.DashboardFragment
import com.project.shoppingapp.fragment.ItemFragment
import com.project.shoppingapp.interfac.DashActivityInterface
import com.project.shoppingapp.interfac.DashbordFragmentInterface

class DashBoardActivity :BaseActivity(),DashActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        Utils.dashActivityInterface=this


        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, DashboardFragment(), "DashboardFragment").commit()


    }

    override fun show(category: String, product: String) {

        val mFragment = ItemFragment()
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mBundle = Bundle()
        mBundle.putString("category",category)
        mBundle.putString("product",product)
        mFragment.arguments = mBundle
       mFragmentTransaction.replace(R.id.frame, mFragment).commit()

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.frame, ItemFragment(), "ItemFragment").commit()


    }


}