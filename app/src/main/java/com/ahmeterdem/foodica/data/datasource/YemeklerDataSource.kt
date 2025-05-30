package com.ahmeterdem.foodica.data.datasource

import com.ahmeterdem.foodica.data.entity.Yemekler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(private val yemeklerDao: YemeklerDaoRetrofit) {

    suspend fun yemekleriYukle(): List<Yemekler> = withContext(Dispatchers.IO) {
        return@withContext yemeklerDao.tumYemekleriYukle().yemekler
    }

}