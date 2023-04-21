class ReverseAnArray {
}

fun main(args:Array<String>){

    var array:Array<Int?> = arrayOf(1,2,3,4,5)
    reverseAnArray(array)
}

fun reverseAnArray(array: Array<Int?>) {
    var temp = arrayOfNulls<Int>(array.size)
    for (i in array.indices){
        temp[array.size-1-i] = array[i]
    }
    print("reverse elements of an array:")
    for (i in temp.indices){
        array[i] = temp[i]
        print(array[i] )
        print("\t")
    }

}
