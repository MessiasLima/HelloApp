package io.github.messiaslima.common.resource

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ResourceTest {

    lateinit var message: String
    lateinit var throwable: Throwable
    lateinit var content: Any
    lateinit var resourceSuccess: Resource<Any>
    lateinit var resourceError: Resource<Any>
    lateinit var resourceLoading: Resource<Any>

    @BeforeEach
    fun setup() {
        message = "some message"
        content = Math.random()
        throwable = Throwable()
        resourceSuccess = Resource.success(content)
        resourceError = Resource.error(throwable = throwable, msg = message)
        resourceLoading = Resource.loading()
    }

    @Test
    fun isLoading() {
        assertTrue(resourceLoading.isLoading())
        assertFalse(resourceSuccess.isLoading())
        assertFalse(resourceError.isLoading())
    }

    @Test
    fun isError() {
        assertTrue(resourceError.isError())
        assertFalse(resourceSuccess.isError())
        assertFalse(resourceLoading.isError())
    }

    @Test
    fun isSuccess() {
        assertFalse(resourceError.isSuccess())
        assertTrue(resourceSuccess.isSuccess())
        assertFalse(resourceLoading.isSuccess())
    }

    @Test
    fun getStatus() {
        assertEquals(Resource.Status.ERROR, resourceError.status)
        assertEquals(Resource.Status.LOADING, resourceLoading.status)
        assertEquals(Resource.Status.SUCCESS, resourceSuccess.status)
    }

    @Test
    fun getData() {
        assertEquals(content, resourceSuccess.data)
    }

    @Test
    fun getMessage() {
        assertEquals(message, resourceError.message)
    }

    @Test
    fun getThrowable() {
        assertEquals(throwable, resourceError.throwable)
    }

    @Test
    fun createSuccess() {
        val resource = Resource.success(content)
        assertEquals(Resource.Status.SUCCESS, resource.status)
        assertTrue(resource.isSuccess())
        assertEquals(content, resource.data)
    }
}
