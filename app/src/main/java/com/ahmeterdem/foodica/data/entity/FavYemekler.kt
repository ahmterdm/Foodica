package com.ahmeterdem.foodica.data.entity


@Entity(tableName = "favori_yemekler")
data class FavYemekler(
    @PrimaryKey(autoGenerate = false)
    val yemek_adi : String,
    val yemek_resim_adi : String,
    val yemek_fiyat : Int,
    val yemek_id : Int = 0)
