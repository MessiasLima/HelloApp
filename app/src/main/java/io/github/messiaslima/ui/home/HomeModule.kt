package io.github.messiaslima.ui.home

import io.github.messiaslima.repository.greeting.GreetingRepository
import io.github.messiaslima.repository.greeting.GreetingRepositoryImpl
import io.github.messiaslima.repository.location.LocationRepository
import io.github.messiaslima.repository.location.LocationRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory<LocationRepository> { LocationRepositoryImpl(get()) }
    factory<GreetingRepository> { GreetingRepositoryImpl(get()) }
    viewModel { HomeViewModel(get(), get()) }
}
