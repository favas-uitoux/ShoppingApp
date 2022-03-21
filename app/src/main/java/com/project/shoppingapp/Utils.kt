package com.project.shoppingapp

import com.project.shoppingapp.interfac.DashActivityInterface
import com.project.shoppingapp.interfac.DashbordFragmentInterface

class Utils {

    companion object {
        val  Database = "TestDB"


         lateinit var dashInterface: DashbordFragmentInterface
         lateinit var dashActivityInterface:  DashActivityInterface
          var previouslySelected =""

    }
}