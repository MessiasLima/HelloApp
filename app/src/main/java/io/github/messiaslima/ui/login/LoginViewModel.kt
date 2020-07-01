package io.github.messiaslima.ui.login

import androidx.lifecycle.ViewModel
import io.github.messiaslima.repository.AuthorizationRepository

class LoginViewModel(
    private val authorizationRepository: AuthorizationRepository
) : ViewModel() {
    fun performLogin(login: String, password: String) {
        TODO("Not yet implemented")
    }
}
