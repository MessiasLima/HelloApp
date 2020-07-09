package io.github.messiaslima.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import io.github.messiaslima.repository.greeting.Greeting
import io.github.messiaslima.repository.greeting.GreetingRepository
import io.github.messiaslima.repository.location.Location
import io.github.messiaslima.repository.location.LocationRepository
import org.apache.commons.text.StringEscapeUtils

class HomeViewModel(
    private val locationRepository: LocationRepository,
    private val greetingRepository: GreetingRepository
) : ViewModel() {

    private val _locationResource = locationRepository.getLocation()

    private val _location = MediatorLiveData<Location>().apply {
        addSource(_locationResource) {
            if (it.isSuccess()) {
                value = it.data
            }
        }
    }

    val location: LiveData<Location> = _location

    private val _greetingResource = _location.switchMap {
        greetingRepository.getGreeting(it.ipAddress)
    }

    private val _greeting = MediatorLiveData<Greeting>().apply {
        addSource(_greetingResource) {
            if (it.isSuccess()) {
                value = it.data
            }
        }
    }

    val greeting: LiveData<String> = _greeting.map { formatGreetingMessage(it) }

    private fun formatGreetingMessage(it: Greeting): String {
        val formatted = StringEscapeUtils.unescapeHtml4(it.hello)
        return "$formatted $username"
    }

    var username: String? = null
}
