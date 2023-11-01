package com.example.mealicious.di

import android.content.Context
import androidx.room.Room
import com.example.mealicious.BuildConfig
import com.example.mealicious.data.api.MealApi
import com.example.mealicious.data.database.MealDatabase
import com.example.mealicious.util.BASE_URL
import com.example.mealicious.util.MEAL_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                setLevel(HttpLoggingInterceptor.Level.NONE)
            }
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(
        okHttpClient: OkHttpClient
    ): MealApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MealApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMealDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MealDatabase::class.java,
        MEAL_TABLE
    ).build()

    @Provides
    @Singleton
    fun provideMealDao(
        mealDatabase: MealDatabase
    ) = mealDatabase.mealDao
}