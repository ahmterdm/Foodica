package com.ahmeterdem.foodica.data.entity

data class SepetYemeklerCevap(
    @SerializedName("sepet_yemekler") val sepetYemekler: List<SepetYemek>,
    @SerializedName("success") val success: Int
)