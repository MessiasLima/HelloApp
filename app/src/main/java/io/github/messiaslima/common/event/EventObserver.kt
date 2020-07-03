package io.github.messiaslima.common.event

import androidx.lifecycle.Observer

class EventObserver<T>(private val callback: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(t: Event<T>?) {
        t?.getContentIfNotHandled()?.let {
            callback.invoke(it)
        }
    }
}
