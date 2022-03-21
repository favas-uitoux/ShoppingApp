package com.project.shoppingapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.shoppingapp.database.entity.CategoryEntity

@Dao
interface CategoryEntityDao {


    @Query("Select distinct category from product")
    fun readAllCategoryNames(): MutableList<String>

    @Query("Select distinct category from product")
    fun showSavedCategoryNames(): MutableList<String>


    @Query("Select Count(*) from product")
    fun readSize():Int

    @Query("Select * from product")
    fun readAllCategory(): MutableList<CategoryEntity>

    @Query("Select * from product where category=:category")
    fun readSpecificProducts(category:String): MutableList<CategoryEntity>


    @Query("Select * from product where category=:category  and title=:product")
    fun readDetailsOfAProduct(category:String,product:String): CategoryEntity


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveDatas(tbl: CategoryEntity):Long


    @Query("Delete  from  product")
    fun clearDatas():Void


    @Query("Select Count(*) from product")
    fun readLiveSize():LiveData<Int>

}