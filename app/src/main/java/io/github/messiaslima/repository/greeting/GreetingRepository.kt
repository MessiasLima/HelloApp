package io.github.messiaslima.repository.greeting

import androidx.lifecycle.LiveData
import io.github.messiaslima.common.resource.Resource

interface GreetingRepository {
    fun getGreeting(ip: String): LiveData<Resource<Greeting>>
}