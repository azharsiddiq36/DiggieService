package com.example.diggieservice

import android.content.Context
import com.example.rdiandroiddevelopertest.repository.RetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context):RetrofitRepository{
        return RetrofitRepository(context)
    }

}