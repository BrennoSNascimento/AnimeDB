package com.example.animedb.base

import com.example.animedb.data.api.HomeApi
import com.example.animedb.domain.repository.home.HomeRepository
import com.example.animedb.domain.repository.home.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideHomeRepository(homeApi: HomeApi) : HomeRepository {
        return HomeRepositoryImpl(homeApi)
    }

}