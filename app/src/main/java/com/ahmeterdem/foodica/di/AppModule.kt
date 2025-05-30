package com.ahmeterdem.foodica.di

import android.content.Context

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    //Yemekler
    fun provideYemeklerRepository(yds : YemeklerLocalDataSource) : YemekRetroRepository{
        return YemekRetroRepository(yds)
    }
    @Provides
    @Singleton
    fun provideYemeklerDataSource(ydao : YemeklerDaoRetrofit) : YemeklerLocalDataSource{
        return YemeklerLocalDataSource(ydao)
    }
    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDaoRetrofit{
        return ApiUtils.getYemeklerDao()
    }
    @Provides
    @Singleton
    //Sepet
    fun provideSepetRepository(sds : SepetDataSource) : SepetRepository {

        return SepetRepository(sds)
    }
    @Provides
    @Singleton
    fun provideSepetDataSource(sdao : SepetlerDaoRetrofit) : SepetDataSource {

        return SepetDataSource(sdao)
    }
    @Provides
    @Singleton
    fun provideSepetDao() : SepetlerDaoRetrofit {

        return ApiUtils.getSepetlerDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideFavoriDao(appDatabase: AppDatabase) : FavoriYemeklerDao{
        return appDatabase.favoriYemeklerDao()
    }

    @Provides
    @Singleton
    fun provideFavoriYemeklerDataSource(favoriDao : FavoriYemeklerDao) : FavoriYemeklerDataSource{

        return FavoriYemeklerDataSource(favoriDao)


    }

    @Provides
    @Singleton

    fun provideFavoriYemeklerRepository(favorids : FavoriYemeklerDataSource) : FavoriYemeklerRepository {
        return FavoriYemeklerRepository(favorids)
    }