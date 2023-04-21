import kotlinx.coroutines.runBlocking
import org.jetbrains.annotations.TestOnly
import org.junit.Assert
import org.junit.Test

class simpletest {

    @Test
    fun myFirstTest() = runBlocking{
        //runBlocking creates a coroutines builder that block the thread on which it works
        myOwnSuspendingFunc()
        Assert.assertEquals(10, 5+5)
    }

}