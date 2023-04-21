import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking { //Thread:main //Creates a coroutine that blocks the current main thread
        println("Main program starts: ${Thread.currentThread().name}")

        println("Global Scope Coroutines")
        val jobDeffered: Deferred<Int> = async { //Thread : main , for thread t1 coroutines c1 will be attached
            //GlobalScope.launch() is non-blocking in nature whereas
            //Unline threads, for coroutines the application by default does not wait for it to finish its execution
            println("Fake work starts: ${Thread.currentThread().name}")   //Thread: T1
            delay(1000)  //Coroutine  C1 is suspended but Thread: T1 is free(not blocked)
            println("Fake work finsihed: ${Thread.currentThread().name}") //Either T1 or some other thread
             15

        }


        val num:Int = jobDeffered.await()

//        jobDeffered.join()

        println(" returnable value from await() function is: ${num}")
        println("Main program ends: ${Thread.currentThread().name}")

    }

}