package com.sorabh.expression_calculator.di.modul

import com.sorabh.expression_calculator.data.api.ApiConnector
import com.sorabh.expression_calculator.data.api.ApiConnectorImpl
import com.sorabh.expression_calculator.data.api.ApiService
import com.sorabh.expression_calculator.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModel {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesApiConnector(apiConnectorImpl: ApiConnectorImpl):ApiConnector = apiConnectorImpl
}