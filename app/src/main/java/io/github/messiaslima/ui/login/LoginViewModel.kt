package io.github.messiaslima.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import io.github.messiaslima.common.event.Event
import io.github.messiaslima.repository.authorization.AuthorizationRepository
import io.github.messiaslima.ui.login.dto.SignInDTO

class LoginViewModel(
    private val authorizationRepository: AuthorizationRepository
) : ViewModel() {

    private val _performSignInEvent = MutableLiveData<SignInDTO>()
    private val _authorizationResource = _performSignInEvent.switchMap {
        authorizationRepository.signIn(it.login, it.password)
    }
    val isLoading = _authorizationResource.map { it.isLoading() }
    val error: LiveData<Throwable?> = _authorizationResource.map {
        if (it.isError()) {
            it.throwable
        } else {
            null
        }
    }
    val signInEvent: LiveData<Event<Boolean?>> = _authorizationResource.map {
        if (it.isSuccess()) {
            return@map Event(it.data == true)
        } else {
            return@map Event(null)
        }
    }

    fun performSignIn(login: String, password: String) {
        _performSignInEvent.value = SignInDTO(login, password)
    }
}
