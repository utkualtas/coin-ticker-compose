package com.utkualtas.core.database.di

import android.content.Context
import androidx.room.Room
import com.utkualtas.core.database.CoinTickerDatabase
import com.utkualtas.core.database.dao.CoinDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CoinTickerDatabase {
        return Room.databaseBuilder(
            appContext,
            CoinTickerDatabase::class.java,
            "CoinTickerDB"
        ).build()
    }

    @Provides
    fun provideCoinDao(db: CoinTickerDatabase): CoinDao {
        return db.coinDao()
    }

}
