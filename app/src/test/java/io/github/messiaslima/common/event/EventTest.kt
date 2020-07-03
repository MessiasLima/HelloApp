package io.github.messiaslima.common.event

import org.junit.Assert.*
import org.junit.Test

class EventTest {

    @Test
    fun getHasBeenHandled_false() {
        val event = Event(1)
        assertFalse(event.hasBeenHandled)
    }

    @Test
    fun getHasBeenHandled_true() {
        val event = Event(1)
        event.getContentIfNotHandled()
        assertTrue(event.hasBeenHandled)
    }

    @Test
    fun getContentIfNotHandled() {
        val content = 1
        val event = Event(content)
        assertEquals(content, event.getContentIfNotHandled())
    }

    @Test
    fun getContentIfNotHandled_when_already_handled() {
        val content = 1
        val event = Event(content)
        event.getContentIfNotHandled()
        assertNull(event.getContentIfNotHandled())
    }

    @Test
    fun getContent() {
        val content = 1
        val event = Event(content)
        assertEquals(content, event.getContent())
    }
}