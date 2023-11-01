package com.example.mealicious.di

import com.example.mealicious.data.api.MealApi
import com.example.mealicious.data.repository.MealRepository
import com.example.mealicious.data.repository.MealRepositoryImpl
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
}