import java.util.*

fun main(args:Array<String>){
    var n = 10
    var a = 0
    var b = 1
    print("Fibbonaci Series ")
    for( i in 1 ..n){
        print("$a \t")
        var sum = a + b
        a = b
        b = sum

    }
}