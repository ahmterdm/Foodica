package com.ahmeterdem.foodica.retrofit

import com.ahmeterdem.foodica.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDao{

    @GET("tumYemekleriGetir.php")
    suspend fun tumYemekleriYukle(): YemeklerCevap

}