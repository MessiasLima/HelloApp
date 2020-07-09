package io.github.messiaslima.repository.location

import com.google.gson.annotations.SerializedName

data class Location(
    val status: String,

    val country: String,

    val countryCode: String,

    val region: Int,

    val regionName: String,

    val city: String,

    val zip: String,

    @SerializedName("lat")
    val latitude: Double,

    @SerializedName("lon")
    val longitude: Double,

    val timezone: String,

    val isp: String,

    val org: String,

    @SerializedName("as")
    val serviceProvider: String,

    @SerializedName("query")
    val ipAddress: String
)
