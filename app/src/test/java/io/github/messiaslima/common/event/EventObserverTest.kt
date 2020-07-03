package io.github.messiaslima.common.event

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class EventObserverTest {

    @Test
    fun onChanged() {
        val content = Math.random().toString()
        val observer = EventObserver<String> {
            assertEquals(content, it)
        }
        observer.onChanged(Event(content))
    }

    @Test
    fun onChanged_null() {
        val observer = EventObserver<String> {
            fail("Should not invoke callback if content is null")
        }
        observer.onChanged(null)
    }
}