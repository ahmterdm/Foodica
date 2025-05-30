package com.ahmeterdem.foodica.room

@Database (entities = [FavoriYemekler::class], version = 1)
abstract  class AppDB : RoomDatabase(){

    abstract fun favoriYemeklerDao() : FavoriYemeklerDao
}