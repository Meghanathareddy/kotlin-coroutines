import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking { //Thread:main //Creates a coroutine that blocks the current main thread
        println("Main program starts: ${Thread.currentThread().name}")
        println("Global Scope Coroutines")
        val job: Job = launch { //Thread : main , for thread t1 coroutines c1 will be attached
            //GlobalScope.launch() is non-blocking in nature whereas
            //Unline threads, for coroutines the application by default does not wait for it to finish its execution
            for( i in 0..500) {

                print("$i.")
                yield()  //or use delay() or any other suspending function as per you need.

            }

        }
        //yield function is that it yields the thread(or thread pool) of the current coroutine dispatcher to other coroutines on the same dispatcher to run if possible

        delay(20) // main Thread: wait for coroutine to finish (pratically not a right way to wait)
        job.cancel()
        job.join()

        println("Main program ends: ${Thread.currentThread().name}")

    }

}