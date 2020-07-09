package io.github.messiaslima.ui.login

import io.github.messiaslima.repository.authorization.AuthorizationRepository
import io.github.messiaslima.repository.authorization.AuthorizationRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    factory<AuthorizationRepository> { AuthorizationRepositoryImpl() }
    viewModel { LoginViewModel(get()) }
}
