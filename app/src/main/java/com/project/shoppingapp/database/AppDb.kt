package com.project.shoppingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.shoppingapp.Utils
import com.project.shoppingapp.database.dao.CategoryEntityDao
import com.project.shoppingapp.database.entity.CategoryEntity

@Database(version = 10, entities = [CategoryEntity::class], exportSchema = false)
abstract class Appdb : RoomDatabase() {


    abstract fun getCategoryEntityDao(): CategoryEntityDao


    companion object {

        private var INSTANCE: Appdb? = null

        fun getDatabaseInstance(context: Context): Appdb {

            val tempInstance = INSTANCE
            if (tempInstance == null) {


                synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        Appdb::class.java, Utils.Database
                    )   .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().build()

                    INSTANCE = instance

                    return instance

                }

            }

            return INSTANCE!!


        }


    }


}