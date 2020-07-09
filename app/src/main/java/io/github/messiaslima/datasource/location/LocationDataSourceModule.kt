package io.github.messiaslima.datasource.location

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val locationDataSourceModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("http://ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<LocationAPI>(LocationAPI::class.java)
    }

    single {
        LocationDataSource(get())
    }
}
