package io.github.messiaslima.ui.login

import io.github.messiaslima.repository.AuthorizationRepository
import io.github.messiaslima.repository.AuthorizationRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    single<AuthorizationRepository> { AuthorizationRepositoryImpl() }
    viewModel { LoginViewModel(get()) }
}
