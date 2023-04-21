import kotlinx.coroutines.*


//Code execution within coroutine is by default sequential
fun main(args:Array<String>){   //Executes in main thread



    //runBlocking() blocks the thread in which it operates
    runBlocking {
        //creates a blocking coroutine that executes in current thread(main)
        println("runBlocking: $this")
        println("Main program starts: ${Thread.currentThread().name}")
       launch {
           println("launch:$this")
           launch(coroutineContext){
               println("child launch: $this")
           }
       }



        async {
            println("async:$this")
        }


    }

}

