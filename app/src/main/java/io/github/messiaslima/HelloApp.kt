package io.github.messiaslima

import android.app.Application
import io.github.messiaslima.datasource.greeting.greetingDataSourceModule
import io.github.messiaslima.datasource.location.locationDataSourceModule
import io.github.messiaslima.ui.home.homeModule
import io.github.messiaslima.ui.login.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HelloApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@HelloApp)
            modules(
                locationDataSourceModule,
                greetingDataSourceModule,
                loginModule,
                homeModule
            )
        }
    }
}
