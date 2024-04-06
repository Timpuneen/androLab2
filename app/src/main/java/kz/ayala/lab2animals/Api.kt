package kz.ayala.lab2animals

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @Headers("X-Api-Key:wgUk2pPCZEs4capvyy5Jxg==iinsRZL1CITI0qZF")
    @GET("animals")
    fun getAnimalsByName(@Query("name") name: String): Call<List<Animal>>
}