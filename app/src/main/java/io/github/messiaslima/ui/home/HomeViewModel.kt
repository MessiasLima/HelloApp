package io.github.messiaslima.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.messiaslima.repository.location.Location
import io.github.messiaslima.repository.location.LocationRepository

class HomeViewModel(
    private val locationRepository: LocationRepository
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
}
