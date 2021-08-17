package com.example.diggieservice.di

import com.example.diggieservice.enum.Constant
import com.example.diggieservice.lib.PictureLib
import com.example.rdiandroiddevelopertest.api.DigieServiceInterface
import com.example.rdiandroiddevelopertest.repository.NavigatorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constant.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String): DigieServiceInterface =
        Retrofit.Builder()
        .client(OkHttpClient().newBuilder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(DigieServiceInterface::class.java)

    @Provides
    @Singleton
    fun providePictLib() = PictureLib

    @Provides
    @Singleton
    fun provideNavigatorRepository() = NavigatorRepository


}