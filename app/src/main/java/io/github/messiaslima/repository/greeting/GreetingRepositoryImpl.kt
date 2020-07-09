package io.github.messiaslima.repository.greeting

import io.github.messiaslima.datasource.greeting.GreetingDataSource

class GreetingRepositoryImpl(
    private val greetingDataSource: GreetingDataSource
) : GreetingRepository {
    override fun getGreeting(ip: String) = greetingDataSource.getGreeting(ip)
}
