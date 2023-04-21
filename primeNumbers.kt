// print n first prime numbers
fun main() {
    var count = 0
//    var noOfItems = readLine()?.toInt()
    var noOfItems = 7
    var number = 2


    while(count < noOfItems)
    {

        var i = 2
        while(i < number){
            // if number is divisble by i then number is not prime number
            if(number%i == 0 ){
                break
            }
            i += 1
        }

        if(i == number){
            println("$i is a prime number")
            count += 1

        }

        number += 1
//        println("$number")

    }
}
