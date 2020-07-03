package io.github.messiaslima.common

fun runOnBackground(runnable: () -> Unit) {
    Thread(runnable).start()
}
