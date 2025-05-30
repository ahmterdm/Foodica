package com.ahmeterdem.foodica.data.datasource

class FavYemeklerDataSource(private val dao: FavYemeklerDao) {

    suspend fun getAllFavoriYemekler(): List<FavoriYemekler> = dao.getAllFavoriYemekler()

    suspend fun insertFavoriYemek(favoriYemek: FavoriYemekler) = dao.insertFavoriYemek(favoriYemek)

    suspend fun deleteFavoriYemek(favoriId : Int) = dao.deleteFavoriYemek(favoriId)

    suspend fun isFavori(yemekAdi: String) = dao.isFavori(yemekAdi)
}