//package com.example.core_network.di
//
//import com.example.core_network.ChampionService
//import com.example.core_network.RequestDebugInterceptor
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import javax.inject.Singleton
//
//@InstallIn(SingletonComponent::class)
//@Module
//class NetworkModule {
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(httpClient)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//
//
//    @Provides
//    @Singleton
//    fun provideChampionService(retrofit: Retrofit): ChampionService {
//        return retrofit.create(ChampionService::class.java)
//    }
//
//
//    @Provides
//    @Singleton
//    fun provideRequestDebugInterceptor(): RequestDebugInterceptor {
//        return RequestDebugInterceptor()
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(interceptor: RequestDebugInterceptor): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            .build()
//    }
//
//    companion object {
//        private const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/11.16.1/"
//    }
//}
//
