import kotlinx.coroutines.*

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking { //Thread:main //Creates a coroutine that blocks the current main thread

        println("Main program starts: ${Thread.currentThread().name}")
        println("Global Scope Coroutines")
        val job: Job = launch(Dispatchers.Default) { //Thread : main , for thread t1 coroutines c1 will be attached
            //GlobalScope.launch() is non-blocking in nature whereas
            //Unline threads, for coroutines the application by default does not wait for it to finish its execution

            try {
                for( i in 0..500) {

                    print("$i.")
                    delay(5)  //or use yield() or any other suspending function as per you need.
                }
            }catch (ex:CancellationException) {
                    println("\nException caught safely")
            }finally {
                withContext(NonCancellable) {
                    delay(1000)  //Generally we don't use suspending function in finally
                    println("\nclose resources in finally")
                }
            }

        }
    delay(10) // main Thread: wait for coroutine to finish (pratically not a right way to wait)
    job.cancel(CancellationException("my own crash message"))
    job.join()

        println("Main program ends: ${Thread.currentThread().name}")

    }

}