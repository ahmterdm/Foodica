package com.ahmeterdem.foodica.data.repo

import com.ahmeterdem.foodica.data.datasource.YemeklerDataSource
import com.ahmeterdem.foodica.data.entity.Yemekler
import javax.inject.Inject

class YemeklerRepository (var yds : YemeklerLocalDataSource) {

    suspend fun tumYemekleriGetir() : List<Yemekler> = yds.yemekleriYukle()

}
