import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking { //Thread:main //Creates a coroutine that blocks the current main thread
        println("Main program starts: ${Thread.currentThread().name}")

        println("Global Scope Coroutines")
        val job: Job = launch(Dispatchers.Default) { //Thread : main , for thread t1 coroutines c1 will be attached
            //GlobalScope.launch() is non-blocking in nature whereas
            //Unline threads, for coroutines the application by default does not wait for it to finish its execution

            for( i in 0..500) {

                if(!isActive){
                   return@launch //break
                }
                print("$i.")
                Thread.sleep(1)  //Coroutine  C1 is suspended but Thread: main is free(not blocked)

            }

        }



        delay(10) // main Thread: wait for coroutine to finish (pratically not a right way to wait)
        job.cancelAndJoin()

        println("Main program ends: ${Thread.currentThread().name}")

    }

}