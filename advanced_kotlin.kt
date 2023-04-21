import java.awt.Color

interface ICardCashBack {
    fun getCashbackValue():Float

}
enum class CreditClassCardTypes(val color:String,val maxlimit:Int = 100000):ICardCashBack{
    SILVERS("gray", 50000){
                          override fun getCashbackValue():Float = 0.02f
                          },  //ordinal = 0  name = "SILVER"
    GOLDS("glod"){
        override fun getCashbackValue():Float = 0.04f
    }   ,  //ordinal = 1  name = "GOLD"
    PLATINUMS("black")  {
        override fun getCashbackValue():Float = 0.06f
    } //ordinal = 2  name = "PLATINUM"

}

fun main(args: Array<String>) {


    /* Enum constants are objects of enum class Type */
    val meghaCardType:CreditClassCardType = CreditClassCardType.GOLD

    /* Each enum object has two properties :ordinal and name */
    println(CreditClassCardType.GOLD.ordinal)
    println(CreditClassCardType.GOLD)  // OR CreditClassCardType.GOLD.name

    /*Each enum object has two methods :values() and valuesOf() */
    val myConstants: Array<CreditClassCardType> = CreditClassCardType.values()
    myConstants.forEach { println(it) }

    /*Using in 'when' statement*/
    when(meghaCardType){
        CreditClassCardType.SILVER -> println("Megha has silver card")
        CreditClassCardType.GOLD -> println("Megha has GOLD card")
        CreditClassCardType.PLATINUM -> println("Megha has platinum card")
    }


}