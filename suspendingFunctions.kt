import kotlinx.coroutines.*

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking {
        //creates a blocking coroutine that executes in current thread(main)
        println("Main program starts: ${Thread.currentThread().name}")

        val msgOne  = getMessageOne()
        val msgTwo = getMessageTwo()

        println("The entire message is:${msgOne+""+msgTwo}")

        println("Main program ends: ${Thread.currentThread().name}")


    }

}

suspend fun getMessageOne():String{
    delay(1000L)
    return "Hello message from one"
}

suspend fun getMessageTwo():String{
    delay(1000L)
    return "Hello message from two"
}