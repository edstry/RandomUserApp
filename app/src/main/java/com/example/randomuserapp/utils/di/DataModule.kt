package com.example.randomuserapp.utils.di

import com.example.randomuserapp.data.network.api.ApiFactory
import com.example.randomuserapp.data.network.api.ApiService
import com.example.randomuserapp.data.repository.UsersRepositoryImpl
import com.example.randomuserapp.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    companion object {
        @Provides
        @Singleton
        fun provideApiService(): ApiService = ApiFactory.apiService

        @Provides
        @Singleton
        fun provideUserRepository(apiService: ApiService): UsersRepository {
            return UsersRepositoryImpl(apiService)
        }
    }
}