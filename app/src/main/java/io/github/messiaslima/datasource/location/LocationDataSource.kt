package io.github.messiaslima.datasource.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.messiaslima.common.resource.Resource
import io.github.messiaslima.repository.location.Location
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationDataSource(private val locationAPI: LocationAPI) {
    fun getLocation(): LiveData<Resource<Location>> {
        val resource = MutableLiveData<Resource<Location>>();
        locationAPI.getLocation().enqueue(object : Callback<Location> {
            override fun onFailure(call: Call<Location>, t: Throwable) {
                resource.value = Resource.error(throwable = t)
            }

            override fun onResponse(call: Call<Location>, response: Response<Location>) {
                resource.value = Resource.success(response.body())
            }
        })
        resource.value = Resource.loading()
        return resource
    }
}