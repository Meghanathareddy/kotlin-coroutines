import kotlinx.coroutines.*

fun main(args:Array<String>){   //Executes in main thread

    //runBlocking() blocks the thread in which it operates
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")
        withTimeout(2000){

                try {
                    for( i in 0..500) {
                        print("$i.")
                        delay(500)  //or use yield() or any other suspending function as per you need.
                    }
                }catch (ex:TimeoutCancellationException) {
                    println("\nException caught safely")
                }finally {
                    println("\nclose resources in finally")
                }


        }


        println("Main program ends: ${Thread.currentThread().name}")


    }

}