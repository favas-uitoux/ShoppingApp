package com.project.shoppingapp.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.project.shoppingapp.apiservice.ApiClient
import com.project.shoppingapp.apiservice.Endpoint
import com.project.shoppingapp.apiservice.pojos.readDashboard.CategoriesItem
import com.project.shoppingapp.apiservice.pojos.readDashboard.ProductsItem
import com.project.shoppingapp.database.dao.CategoryEntityDao
import com.project.shoppingapp.database.entity.CategoryEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRepo(private val categoryEntiityDao: CategoryEntityDao) {


    fun readAllCategoryNames(): MutableList<String> {

        //clearData()
        if(readSize()==0)
        {

        val apiService = ApiClient.getClient(Endpoint::class.java)
        var call = apiService.fetchDashboard();

        call!!.enqueue(object :
            Callback<com.project.shoppingapp.apiservice.pojos.readDashboard.Response> {
            override fun onResponse(
                call: Call<com.project.shoppingapp.apiservice.pojos.readDashboard.Response>,
                response: Response<com.project.shoppingapp.apiservice.pojos.readDashboard.Response>
            ) {

                if (response.isSuccessful) {
                    if (response.body()!!.status!!) {

                        var categories = response.body()!!.categories!!



                        for (row: CategoriesItem? in categories) {

                            var title_main = row?.title
                            var products = row?.products


                            if (products != null) {


                                for (row: ProductsItem? in products!!) {


                                    try {

                                        var title_product = row?.title
                                        var price = row?.price

                                        var imageUrl = row?.imageUrl
                                        var description = row?.description

                                        saveData(
                                            CategoryEntity(
                                                0,
                                                title_main,
                                                title_product,
                                                price,
                                                imageUrl,
                                                description,


                                                )
                                        )
                                    } catch (e: Exception) {
                                    }


                                }
                            }


                        }


                    }
                }


                Log.d("test", "test")

//
//
                Log.d("result", "ok")


            }

            override fun onFailure(
                call: Call<com.project.shoppingapp.apiservice.pojos.readDashboard.Response>,
                t: Throwable
            ) {

                Log.d("result", "failed")

            }
        })


        return categoryEntiityDao.readAllCategoryNames();
        }
        else
        {


            return categoryEntiityDao.readAllCategoryNames();
        }


    }

    fun showSavedCategoryNames(): MutableList<String> {
        return categoryEntiityDao.showSavedCategoryNames();
    }

    fun readLiveSize(): LiveData<Int> {
        return categoryEntiityDao.readLiveSize()
    }

    fun readSize(): Int {
        return categoryEntiityDao.readSize()
    }

    fun readAllCategory(): MutableList<CategoryEntity> {
        return categoryEntiityDao.readAllCategory()
    }


    fun readSpecificProducts(category:String): MutableList<CategoryEntity> {
        return categoryEntiityDao.readSpecificProducts(category)
    }

    fun readDetailsOfAProduct(category:String,product:String): CategoryEntity {
        return categoryEntiityDao.readDetailsOfAProduct(category,product)
    }

    fun saveData(tbl: CategoryEntity): Long {
        return categoryEntiityDao.saveDatas(tbl)
    }

    fun clearData(): Void {
        return categoryEntiityDao.clearDatas()
    }


}