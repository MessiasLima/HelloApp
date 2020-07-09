package io.github.messiaslima.datasource.greeting

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val greetingDataSourceModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://fourtonfish.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<GreetingAPI>(GreetingAPI::class.java)
    }

    single {
        GreetingDataSource(get())
    }
}
