package io.github.messiaslima.datasource.location

import io.github.messiaslima.repository.location.Location
import retrofit2.Call
import retrofit2.http.GET

interface LocationAPI {
    @GET("json")
    fun getLocation(): Call<Location>
}