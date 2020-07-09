package io.github.messiaslima.datasource.greeting

import io.github.messiaslima.repository.greeting.Greeting
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GreetingAPI {
    @GET("hellosalut")
    fun getGreeting(@Query("ip") ip: String): Call<Greeting>
}
