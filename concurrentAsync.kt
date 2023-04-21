import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//Code execution within coroutine is by default sequential
fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking {
        //creates a blocking coroutine that executes in current thread(main)
        println("Main program starts: ${Thread.currentThread().name}")
        val time = measureTimeMillis {
            //Code execution within coroutine is by default sequential
            // but using async execution of the code will be occur in parallel
            val msgOne:Deferred<String>  = async {  getMessageOne2() }
            val msgTwo:Deferred<String>  = async {  getMessageTwo2() }
            println("The entire message is:${msgOne.await() + msgTwo.await()}")
        }


        println("completed in$time ms")
        println("Main program ends: ${Thread.currentThread().name}")


    }

}

suspend fun getMessageOne2():String{
    delay(1000L)
    return "Hello message from one1"
}

suspend fun getMessageTwo2():String{
    delay(1000L)
    return "Hello message from two1"
}