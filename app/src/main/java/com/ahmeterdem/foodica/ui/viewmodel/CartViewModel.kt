package com.ahmeterdem.foodica.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class CartViewModel @Inject constructor(
    private val sepetrepo: SepetRepository

) : ViewModel() {

    // ViewModel içinde


    // ViewModel içinde

    val sepetListesi = MutableLiveData<List<SepetYemek>>()





    init {

        sepettekiYemekleriGetir()
    }

    fun sepettekiYemekleriGetir() {
        viewModelScope.launch {
            try {
                val yemekler = sepetrepo.sepettekiYemekleriGetir()
                Log.d("CartDiscountViewModel", "Yemekler repo'dan: $yemekler")
                sepetListesi.postValue(yemekler)
            } catch (e: Exception) {
                Log.e("CartDiscountViewModel", "Sepet yemekleri getirilemedi", e)
                sepetListesi.postValue(emptyList())
            }
        }
    }


    fun sepettenYemekSil(sepet_yemek_id : Int){
        viewModelScope.launch {
            sepetrepo.sepetYemekSil(sepet_yemek_id)
            sepettekiYemekleriGetir()
        }

    }

    fun toplamparaHesapla(): Int {

        return sepetListesi.value?.sumOf { it.yemek_fiyat * it.yemek_siparis_adet } ?: 0 }




}
