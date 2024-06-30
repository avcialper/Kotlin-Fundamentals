package functions

fun main() {

    calculateAndPrintNormal(3, 5, '+')
    calculateAndPrintNormal(38, 16, '-')
    calculateAndPrintNormal(4, 5, 'x')
    calculateAndPrintNormal(10, 2, '/')

    println("-------------------------------------------")

    val sumFunction = { numberOne: Int, numberTwo: Int ->
        numberOne + numberTwo
    }

    val minusFunction = fun(numberOne: Int, numberTwo: Int): Int {
        return numberOne - numberTwo
    }

    // expression
    val multiplyFunction = fun(numberOne: Int, numberTwo: Int): Int = numberOne * numberTwo

    calculateAndPrint(3, 5) { numberOne, numberTwo ->
        numberOne + numberTwo
    }
    calculateAndPrint(6, 84, sumFunction)

    calculateAndPrint(38, 16) { numberOne, numberTwo ->
        numberOne - numberTwo
    }
    calculateAndPrint(99, 88, minusFunction)

    calculateAndPrint(4, 5) { numberOne, numberTwo ->
        numberOne * numberTwo
    }
    calculateAndPrint(6, 6, multiplyFunction)

    calculateAndPrint(10, 2) { numberOne, numberTwo ->
        numberOne / numberTwo
    }
    calculateAndPrint(15, 5, ::divFunction)

    extensionHOF(15, ::extensionHOFFun)
    extensionHOF2(15, ::extensionHOFFun)
}

fun divFunction(numberOne: Int, numberTwo: Int): Int {
    return numberOne / numberTwo
}

fun calculateAndPrintNormal(numberOne: Int, numberTwo: Int, operation: Char) {
    val result = when (operation) {
        '+' -> numberOne + numberTwo
        '-' -> numberOne - numberTwo
        'x' -> numberOne * numberTwo
        '/' -> numberOne / numberTwo
        else -> "Operation not supported"
    }
    println("Result: $result")
}

//  higher order function (HOF)
fun calculateAndPrint(numberOne: Int, numberTwo: Int, operation: (Int, Int) -> Int) {
    val result = operation(numberOne, numberTwo)
    println("Result: $result")
}

//  Bu ikisi aynı işlemi yapar
fun extensionHOF(number: Int, operation: String.(Int) -> String) {
    val result = operation("Number :", number)
    println("extension hof result: $result")
}

fun extensionHOF2(number: Int, operation: (String, Int) -> String) {
    val result = operation("Number :", number)
    println("extension hof result: $result")
}

//  Beklenen function'daki String.(Int) aslında (String, Int) e karşılık geliyor.
fun extensionHOFFun(message: String, number: Int): String {
    return "$message $number"
}