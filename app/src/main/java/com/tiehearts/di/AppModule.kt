package com.tiehearts.di

import android.content.Context
import com.tiehearts.utils.SharedPrefrence
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideSharedPrefrence(@ApplicationContext context: Context): SharedPrefrence {
        return SharedPrefrence(context)
    }
}