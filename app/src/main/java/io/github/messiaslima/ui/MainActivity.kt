package io.github.messiaslima.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.messiaslima.R
import io.github.messiaslima.repository.AuthorizationRepository
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}