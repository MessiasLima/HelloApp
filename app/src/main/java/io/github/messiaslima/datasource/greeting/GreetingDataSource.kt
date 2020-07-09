package io.github.messiaslima.datasource.greeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.messiaslima.common.resource.Resource
import io.github.messiaslima.repository.greeting.Greeting
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GreetingDataSource(private val greetingAPI: GreetingAPI) {
    fun getGreeting(ip: String): LiveData<Resource<Greeting>> {
        val resource = MutableLiveData<Resource<Greeting>>()
        resource.value = Resource.loading()
        greetingAPI.getGreeting(ip).enqueue(object : Callback<Greeting> {
            override fun onFailure(call: Call<Greeting>, t: Throwable) {
                resource.value = Resource.error(throwable = t)
            }

            override fun onResponse(call: Call<Greeting>, response: Response<Greeting>) {
                resource.value = Resource.success(response.body())
            }
        })
        return resource
    }
}