package pa.chan.starwarsproject.features.home.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.starwarsproject.features.home.data.HomeRepositoryImpl
import pa.chan.starwarsproject.features.home.data.StarWarsApi
import pa.chan.starwarsproject.features.home.domain.HomeRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {
    companion object {
        @Provides
        @Singleton
        fun provideStarWarsApi(retrofit: Retrofit): StarWarsApi =
            retrofit.create(StarWarsApi::class.java)
    }

    @Binds
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}