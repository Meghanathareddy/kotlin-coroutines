import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
//        Unline threads, for coroutines the application by default does not wait for it to finish its execution
        println("Fake work starts: ${Thread.currentThread().name}")   //Thread: T1
        delay(1000)  //Coroutine  C1 is suspended but Thread: T1 is free(not blocked)
        println("Fake work finsihed: ${Thread.currentThread().name}") //Either T1 or some other thread

    }

    //Blocks the current main thread and wait for coroutine to finish (practically not a right way to wait)
    Thread.sleep(2000)
    println("Main program ends: ${Thread.currentThread().name}" )

}