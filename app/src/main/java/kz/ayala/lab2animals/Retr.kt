package kz.ayala.lab2animals

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retr {
    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}