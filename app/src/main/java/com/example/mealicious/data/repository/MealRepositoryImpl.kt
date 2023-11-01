package com.example.mealicious.data.repository

import com.example.mealicious.data.api.MealApi
import com.example.mealicious.data.model.response.AreaResponse
import com.example.mealicious.data.model.response.CategoryResponse
import com.example.mealicious.data.model.response.MealDetailResponse
import com.example.mealicious.data.model.response.MealsResponse
import com.example.mealicious.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi
) : MealRepository {
    override fun getCategory(): Flow<DataResult<CategoryResponse>> = flow {
        try {
            emit(DataResult.Loading())
            val result = mealApi.getCategory()
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve categories"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve categories"
                ))
        }
    }

    override fun getArea(): Flow<DataResult<AreaResponse>> = flow {
        try {
            emit(DataResult.Loading())
            val result = mealApi.getArea()
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve categories"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve categories"
                ))
        }
    }

    override fun getMealDetail(id: String): Flow<DataResult<MealDetailResponse>> = flow {
        try {
            emit(DataResult.Loading())
            val result = mealApi.getMealDetail(id)
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve categories"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve categories"
                ))
        }
    }

    override fun getMealsByCategory(category: String): Flow<DataResult<MealsResponse>> = flow {
        try {
            emit(DataResult.Loading())
            val result = mealApi.getMealsByCategory(category)
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve categories"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve categories"
                ))
        }
    }

    override fun getMealsByArea(area: String): Flow<DataResult<MealsResponse>> = flow {
        try {
            emit(DataResult.Loading())
            val result = mealApi.getMealsByArea(area)
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve categories"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve categories"
                ))
        }
    }

    override fun searchMeals(name: String): Flow<DataResult<MealsResponse>> = flow {
        try {
            emit(DataResult.Loading())
            val result = mealApi.searchMeals(name)
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve categories"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve categories"
                ))
        }
    }
}