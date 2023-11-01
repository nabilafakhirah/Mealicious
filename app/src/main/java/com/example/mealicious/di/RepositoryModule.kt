package com.example.mealicious.di

import com.example.mealicious.data.api.MealApi
import com.example.mealicious.data.dao.MealDao
import com.example.mealicious.data.repository.MealRepository
import com.example.mealicious.data.repository.MealRepositoryImpl
import com.example.mealicious.data.repository.MealStorageRepository
import com.example.mealicious.data.repository.MealStorageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(mealApi: MealApi): MealRepository {
        return MealRepositoryImpl(mealApi)
    }

    @Provides
    @Singleton
    fun provideStorageRepository(mealDao: MealDao): MealStorageRepository {
        return MealStorageRepositoryImpl(mealDao)
    }
}