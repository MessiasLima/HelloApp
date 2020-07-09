package io.github.messiaslima.repository.location

import io.github.messiaslima.datasource.location.LocationDataSource

class LocationRepositoryImpl(
    private val locationDataSource: LocationDataSource
) : LocationRepository {
    override fun getLocation() = locationDataSource.getLocation()
}