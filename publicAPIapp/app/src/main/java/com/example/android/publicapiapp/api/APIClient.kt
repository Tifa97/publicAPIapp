package com.example.android.publicapiapp.api

import com.example.android.publicapiapp.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.sql.Time
import java.util.concurrent.TimeUnit

object APIClient{
    private fun provideHttpClient(): OkHttpClient{
        val interceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG){
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        else{
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor{chain ->  
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    fun authServices(): ApiInterface{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClient())
            .build()
            .create(ApiInterface::class.java)
    }
}