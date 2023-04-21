import kotlinx.coroutines.*



//Code execution within coroutine is by default sequential
fun main(args:Array<String>){   //Executes in main thread



    //runBlocking() blocks the thread in which it operates
    runBlocking {
        //creates a blocking coroutine that executes in current thread(main)

        //this:CoroutineScope instance
        //coroutineContext:CoroutineContext instance

        /* Without Parameter:CONFINED [CONFINED DISPATCHER]
            - Inherits CoroutineContext from immediate parent coroutine
            - Even after delay() or suspending function, it continues to run in the same thread.
        */

        launch {
            println("C1: ${Thread.currentThread().name}") //Thread:main
            delay(1000)
            println("C1 after delay: ${Thread.currentThread().name}") //Thread:main
        }

        /* Without Parameter:Dispatchers.Default [Similar to GlobalScope.lauch{}]
            - Gets its own Context at global level.Executes in a separate background thread.
            -After delay() or suspending Function
                - it continues to run either in the same thread or some other thread.
        */

        launch(Dispatchers.Default) {
            println("C2: ${Thread.currentThread().name}") //Thread:T1
            delay(1000)
            println("C2 after delay: ${Thread.currentThread().name}") //Thread:Either T1 or some other thread
        }


        /* Without Parameter:Dispatchers.Unconfined [CONFINED DISPATCHER]
             - Inherits CoroutineContext from immediate parent coroutine
             - Even after delay() or suspending function, it continues to run in the same other thread.
         */

        launch(Dispatchers.Unconfined) {
            println("C3: ${Thread.currentThread().name}") //Thread:main
            delay(1000)
            println("C3 after delay: ${Thread.currentThread().name}") //Thread:Either T1 or some other thread

        }
        // USING COROUTINECONTEXT PROPERTY TO FLOW CONTEXT FROM PARENT TO CHILD.

        launch(coroutineContext) {
            println("C4: ${Thread.currentThread().name}") //Thread:main
            delay(1000)
            println("C4 after delay: ${Thread.currentThread().name}") //Thread:main

        }
        println("...Main program")
    }
}

