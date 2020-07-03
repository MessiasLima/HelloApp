package io.github.messiaslima.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.messiaslima.common.resource.Resource
import io.github.messiaslima.common.runOnBackground
import io.github.messiaslima.exception.LoginException

class AuthorizationRepositoryImpl : AuthorizationRepository {
    override fun signIn(login: String, password: String): LiveData<Resource<Boolean>> {
        val resource = MutableLiveData<Resource<Boolean>>()
        resource.value = Resource.loading()
        runOnBackground {
            val loginResult = validateCredentials(login, password)
            resource.postValue(loginResult)
        }
        return resource
    }

    private fun validateCredentials(login: String, password: String): Resource<Boolean> {
        Thread.sleep(2000) // Simulate network call

        if (login == LOGIN_ERROR) {
            return Resource.error(throwable = LoginException("Exception to simulate a runtime error"))
        }

        return Resource.success(login == password)
    }

    companion object {
        const val LOGIN_ERROR = "error"
    }
}
