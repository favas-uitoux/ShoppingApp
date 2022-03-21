package com.project.shoppingapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.shoppingapp.apiservice.pojos.readDashboard.CategoriesItem
import com.project.shoppingapp.apiservice.pojos.readDashboard.ProductsItem

@Entity(tableName = "product")
open class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,



    val category:String?,
    val title:String?,
    val price:Int?,
    val imageUrl:String?,
    val description:String?,





    )