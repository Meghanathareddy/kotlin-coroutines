import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(args:Array<String>){   //Executes in main thread

    println("Main program starts: ${Thread.currentThread().name}" )

//    thread{  //creates a background thread(worker thread)
//        println("Fake work starts: ${Thread.currentThread().name}")
//        Thread.sleep(1000)  //Pretend doing some work... may be file upload
//        println("Fake work finsihed: ${Thread.currentThread().name}")
//
//    }


    println("Global Scope Coroutines")
    GlobalScope.launch { //Thread : T1 , for thread t1 coroutines c1 will be attached
        //GlobalScope.launch() is non-blocking in nature whereas

//        Unline threads, for coroutines the application by default does not wait for it to finish its execution
        println("Fake work starts: ${Thread.currentThread().name}")   //Thread: T1
        delay(1000)  //Coroutine  C1 is suspended but Thread: T1 is free(not blocked)
        println("Fake work finsihed: ${Thread.currentThread().name}") //Either T1 or some other thread

    }

    runBlocking { //Creates a coroutine that blocks the current main thread
        //runBlocking() blocks the thread in which it operates
        delay(2000) //wait for coroutine to finish (pratically not a right way to wait)
    }
    println("Main program ends: ${Thread.currentThread().name}" )

}