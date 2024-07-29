package basics.controlflow

fun main() {

    var numberOne = 10
    val numberTwo = 5

    println("NumberOne : $numberOne")
    println("NumberOne : ${numberOne++}")   // Önce yazdır sonra arttır, yani önce ilk değerini kullan
    println("NumberOne : $numberOne")
    println("NumberOne : ${++numberOne}")   // Önce arttır sonra yazdır, yani yeni değerini kullan

    print(numberOne + numberTwo)
    print(" ")
    println(numberOne.plus(numberTwo))

    print(numberOne - numberTwo)
    print(" ")
    println(numberOne.minus(numberTwo))

    print(numberOne * numberTwo)
    print(" ")
    println(numberOne.times(numberTwo))

    print(numberOne / numberTwo)
    print(" ")
    println(numberOne.div(numberTwo))

    print(numberOne % numberTwo)
    print(" ")
    println(numberOne.rem(numberTwo))

    /**
     *      Operatörler nullable değerler ile çalışmazlar. Eğer nullable bir değer ile işlem yapmak istenirse
     *      bu işlemler için olan operatör fonksiyonlar kullanılmalı.
     */

    val sampleNullable: Int? = 50
    // sampleNullable + 20 // hata verir
    sampleNullable?.plus(20) // şeklinde kullanılmalı

    println("--------------------********************--------------------")

    print("Final notunuzu giriniz: ")
    val grade = readLine()!!.toInt()
    val charNote = if (grade == 100) {
        "$grade = AA"
    } else if (grade <= 99 && grade >= 80) {
        "$grade = BB"
    } else if (grade <= 79 && grade >= 50) {
        "$grade = CC"
    } else if (grade <= 49 && grade >= 20) {
        "$grade = DD"
    } else if (grade <= 19 && grade >= 0) {
        "$grade = FF"
    } else {
        "$grade = Bulunamadı!!"
    }
    println(charNote)

    val sampleGrade = 40
    /**
     *      compareTo
     *      grade değeri sampleGrade değerinden;
     *      büyükse -> 1
     *      eşitse -> 0
     *      küçükse -> -1
     *      döner.
     */
    println(grade.compareTo(sampleGrade))
    println(grade.equals(sampleGrade))      // equals iki değerin eşitliğini kontrol eder.

    var a = 10
    val b = 12
    a += b      // a = a + b  eşitliği vardır
    println("a += b = $a")
    a -= b
    println("a -= b = $a")
    a *= b
    println("a *= b = $a")
    a /= b
    println("a /= b = $a")
    a %= b
    println("a %= b = $a")


    var numbOne = 10
    var numbTwo = 5
    var flag = true
    println("+a : " + +numbOne)     // 10
    println("-b : " + -numbTwo)     // -5
    println("++a : " + ++numbOne)   // 11
    println("a++ : " + numbOne++)   // 11
    println("a : " + numbOne)       // 12
    println("--b : " + --numbTwo)   // 4
    println("!flag : " + !flag)     // false

    println(numbTwo + numbOne.unaryMinus())

    numbOne.inc()           // ++numbOne
    numbOne.dec()           // --numbOne
    numbOne.unaryPlus()     // +numbOne; yeniden atama yapmaz istenirse bir eşitlik ile başka bir değere atanabilir.
    numbOne.unaryMinus()    // -numbOne; yeniden atama yapmaz

    /**
     *      == değer kontrolü yapar
     *      === referans kontrolü yapar
     */
}