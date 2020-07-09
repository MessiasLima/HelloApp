package io.github.messiaslima.repository

import io.github.messiaslima.exception.LoginException
import io.github.messiaslima.repository.authorization.AuthorizationRepositoryImpl
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AuthorizationRepositoryImplTest {

    private lateinit var authorizationRepository: AuthorizationRepositoryImpl

    @BeforeEach
    fun setup() {
        authorizationRepository =
            AuthorizationRepositoryImpl()
    }

    @Test
    fun validateCredentials_correct() {
        assertTrue(authorizationRepository.validateCredentials("a", "a").data!!)
    }

    @Test
    fun validateCredentials_failure() {
        assertFalse(authorizationRepository.validateCredentials("a", "b").data!!)
    }

    @Test
    fun validateCredentials_exception() {
        val resource = authorizationRepository.validateCredentials("error", "b")
        assertTrue(resource.throwable is LoginException)
    }
}
