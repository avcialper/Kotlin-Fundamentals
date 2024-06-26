package basics.controlflow

import java.io.IOException

fun main() {

    /**
     *      if else case'lerinden sonra süslü parantez açılır ve kapanır.
     *      Ancak bu süsşü parantezler arasına tek satır kod yazılacaksa süslü parantez kullanmaya gerek yoktur.
     *
     *      If - Else case'lerin state ve expression olmak üzere 2 kullanımı vardır;
     *      State -> sadece if else kullanılarak şartlı şartlı durumlarımızı kodlamak
     *      Expression -> bir value'ya değer olarak eşitliğin karşı tarafına if else kodlarını yazmaktır. Burada fi else
     *                    case'leri için yazılmış parantezlerin son satırı value olarka alınır.
     */

    print("Are you a student = ")
    val answer = readln().trim()

    // State kullanımı
    if (answer.equals("yes", ignoreCase = true)) {
        println("Student")
    } else {
        println("Not a student")
    }

    if (answer.equals("yes", ignoreCase = true))
        println("Student")
    else
        println("Not a student")

    if (answer.equals("Yes", ignoreCase = true)) {
        println("Student")
    } else if (answer.equals("No", ignoreCase = true)) {
        println("Not a student")
    } else {
        println("Unknown")
    }

    // Expression kullanımı
    val result: String = if (answer.equals("yes", ignoreCase = true)) {
        "Student"
    } else if (answer.equals("no", ignoreCase = true)) {
        "Not a student"
    } else {
        "Unknown"
    }
    println("result: $result")

    /**
     *      Kotlin'de if else'lerin Expression kullanımından dolayı ternary operatörü yoktur.
     *      Ternary yerine aşağıdaki gibi bir kullanım yapılabilir.
     */
    val isStudent = false
    val isStudent2 = if (isStudent) {
        "Yes"
    } else {
        "No"
    }

    /**
     *      İki farklı tipteki number depişkenler karşılaştırılırken equals fonksiyonu önce tiplerini karşılaştırdığı için
     *      eğer tipler uyuşmuyorsa, IDE hata verecektir.
     */

//    if(10 == 10L){    // Hata verir.
//
//    }

    if (10 == 10L.toInt()) {
        println("equal")
    }

    /**
     *      Alt alta if yazmak kötü performansa neden olur. Else if yapısı kullanılmalıdır.
     *      Eğer sürekli olarak if if if yazılırsa herhangi bir case'e girse bile altta kalan case'leri de kontrol eder.
     *      Eğer if case'inden sonra else if kullanılırsa, if' e girilmesi durumunda altta kalan else if direkt olarak
     *      atlanır.
     */

    val condition = 10
    if (condition < 5) {
        println("state1")
    }
    if (condition > 5) {
        println("state2")
    }

    // best practice
    if (condition < 5) {
        println("state3")
    } else if (condition > 5) {
        println("state4")
    } else {
        println("state5")
    }

    /**
     *      Bazı durumlarda if else yazmaktansa, if case'ini yazıp return ya da throw gibi kodun devam etmesini bozacak
     *      ifadelerle kodu sonlandırabilirsiniz. Kod çalışırken bu if case'ine girmezse devam eden kod bloğu çalışır ki
     *      bu da pratikte else case'i demek olur. Bu şekilde yazım, kodu biraz daha temiz gösterecektir.
     */
    if (isStudent) {
        println("Student")
    } else {
        otherMethod()
    }

    if (isStudent) {
        println("Student")
        throw IOException()
        //  return
    }
    otherMethod()
}

private fun otherMethod() {}