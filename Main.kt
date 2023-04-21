enum class CreditClassCardType{
    SILVER,   //ordinal = 0  name = "SILVER"
    GOLD,     //ordinal = 1  name = "GOLD"
    PLATINUM ,  //ordinal = 2  name = "PLATINUM"


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