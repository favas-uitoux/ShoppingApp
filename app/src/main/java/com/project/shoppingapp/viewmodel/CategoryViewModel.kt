package com.project.shoppingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.project.shoppingapp.database.Appdb
import com.project.shoppingapp.database.entity.CategoryEntity
import com.project.shoppingapp.repo.CategoryRepo

class CategoryViewModel(application: Application) : AndroidViewModel(application){


    private val repo: CategoryRepo

    init {
        val categoryEntityDao = Appdb.getDatabaseInstance(application).getCategoryEntityDao()
        repo = CategoryRepo(categoryEntityDao)


    }


    fun readAllCategory(): MutableList<CategoryEntity>{
        return repo.readAllCategory()
    }


    fun readSize(): Int{
        return repo.readSize()
    }

    fun readLiveSize(): LiveData<Int>{
        return repo.readLiveSize()
    }

    fun readAllCategoryNames(): MutableList<String>{
        return repo.readAllCategoryNames()
    }


    fun readSpecificProducts(category:String): MutableList<CategoryEntity>{
        return repo.readSpecificProducts(category)
    }



    fun readDetailsOfAProduct(category:String,product:String): CategoryEntity{
        return repo.readDetailsOfAProduct(category, product)
    }


    fun showSavedCategoryNames(): MutableList<String> {
        return repo.showSavedCategoryNames()
    }


}