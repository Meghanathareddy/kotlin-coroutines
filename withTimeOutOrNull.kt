import kotlinx.coroutines.*

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")
        val result:String? = withTimeoutOrNull(2000){


                for( i in 0..500) {
                    print("$i.")
                    delay(500)  //or use yield() or any other suspending function as per you need.
                }
            "I am done with withTimeOutOrNull"



        }

        println("result:$result")


        println("Main program ends: ${Thread.currentThread().name}")


    }

}