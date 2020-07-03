package io.github.messiaslima.repository

import androidx.lifecycle.LiveData
import io.github.messiaslima.common.resource.Resource

interface AuthorizationRepository {
    fun signIn(login: String, password: String): LiveData<Resource<Boolean>>
}
