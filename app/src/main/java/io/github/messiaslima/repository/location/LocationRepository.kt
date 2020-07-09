package io.github.messiaslima.repository.location

import androidx.lifecycle.LiveData
import io.github.messiaslima.common.resource.Resource

interface LocationRepository {
    fun getLocation(): LiveData<Resource<Location>>
}
