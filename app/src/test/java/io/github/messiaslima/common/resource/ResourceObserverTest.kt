package io.github.messiaslima.common.resource

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

class ResourceObserverTest {

    @Test
    fun onChanged_success() {
        val content = "Some string"
        val observer = ResourceObserver<String> {
            assertEquals(content, it)
        }
        observer.onChanged(Resource.success(content))
    }

    @Test
    fun onChanged_error() {
        val observer = ResourceObserver<String> {
            fail()
        }
        observer.onChanged(Resource.error(throwable = Throwable()))
    }

    @Test
    fun onChanged_loading() {
        val observer = ResourceObserver<String> {
            fail()
        }
        observer.onChanged(Resource.loading())
    }
}
