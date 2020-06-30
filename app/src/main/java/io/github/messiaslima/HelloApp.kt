package io.github.messiaslima

import android.app.Application
import io.github.messiaslima.ui.login.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HelloApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@HelloApp)
            modules(loginModule)
        }
    }
}