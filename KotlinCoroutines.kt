import kotlinx.coroutines.GlobalScope
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
   GlobalScope.launch { //creates a background coroutine that runs on a background thread
       //Unline threads, for coroutines the application by default does not wait for it to finish its execution
       println("Fake work starts: ${Thread.currentThread().name}")
       Thread.sleep(1000)  //Pretend doing some work... may be file upload
       println("Fake work finsihed: ${Thread.currentThread().name}")

    }

    //Blocks the current main thread and wait for coroutine to finish (practically not a right way to wait)
    Thread.sleep(2000)
    println("Main program ends: ${Thread.currentThread().name}" )

}