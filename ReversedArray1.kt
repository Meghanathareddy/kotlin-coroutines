
fun main(args:Array<String>){

    var array:Array<Int?> = arrayOf(1,2,3,4,45,5,56)
    println(reverseAnArray1(array))
}
fun swap(array:Array<Int?>, low:Int, high:Int){
    var temp = array[low]
    array[low] = array[high]
    array[high]= temp
}

fun reverseAnArray1(array: Array<Int?>): String {
    var low = 0
    var high = array.size -1
    while (low < high){
        swap(array,low,high)
        low++
        high--
    }
    return array.contentToString()

}
