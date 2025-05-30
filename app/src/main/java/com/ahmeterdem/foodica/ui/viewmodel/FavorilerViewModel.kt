package com.ahmeterdem.foodica.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class FavorilerViewModel @Inject constructor(var favorirepo : FavoriYemeklerRepository) : ViewModel() {

    val favorilistesi = MutableLiveData<List<FavoriYemekler>>()

    init {
        favoriYemekleriYukle()
    }

    fun favoriYemekleriYukle() {
        viewModelScope.launch(Dispatchers.IO) {  // IO thread
            val liste = favorirepo.getAllFavoriYemekler()
            withContext(Dispatchers.Main) {
                // Ana thread'de LiveData güncelle
                favorilistesi.value = liste
            }
        }
    }






    fun favoridenYemekSil(yemek_id : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            favorirepo.favoriSil(yemek_id)  // IO thread'de çalışmalı
            favoriYemekleriYukle()          // Yine IO thread içinde veriyi yenile
        }
    }

}