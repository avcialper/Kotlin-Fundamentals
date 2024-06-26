package basics.controlflows

data class PairNumber(val numberOne: Int, val numberTwo: Int) {

    operator fun minus(pairNumber: PairNumber): PairNumber {

        val localNumberOne = numberOne + pairNumber.numberOne
        val localNumberTwo = numberTwo + pairNumber.numberTwo

        val returnPairObject = PairNumber(localNumberOne, localNumberTwo)

        println("Result = (${returnPairObject.numberOne}, ${returnPairObject.numberTwo})")

        return returnPairObject
    }
}

fun main() {

    val a: Int = 5
    val b = 8

    // operatörler arka planda esnekliği olan (corresponding) methodu çağırır.
    var result = a + b
    result = a.plus(b)

    val pairNumberOne = PairNumber(2, 4)
    val pairNumberTwo = PairNumber(-8, 11)

    val resultOne = pairNumberOne.numberOne - pairNumberOne.numberTwo
    val resultTwo = pairNumberTwo.numberOne - pairNumberTwo.numberTwo
    println("Result = ($resultOne, $resultTwo)")

    // Class'a özel operator function yazıldı.
    pairNumberOne - pairNumberTwo
    pairNumberOne.minus(pairNumberTwo)
}