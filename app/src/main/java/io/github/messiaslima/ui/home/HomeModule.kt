package io.github.messiaslima.ui.home

import io.github.messiaslima.repository.location.LocationRepository
import io.github.messiaslima.repository.location.LocationRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory<LocationRepository> { LocationRepositoryImpl(get()) }
    viewModel { HomeViewModel(get()) }
}
