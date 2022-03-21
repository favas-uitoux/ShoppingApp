package com.project.shoppingapp.apiservice.pojos.readDashboard

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class ProductsItem(

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class CategoriesItem(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)
