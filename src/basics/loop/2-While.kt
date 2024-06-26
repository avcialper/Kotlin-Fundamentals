package basics.loop

fun main() {

    /**
     *      Diğer diller ile aynı kullanımı vardır.
     *      Eğer bir döngüye ihtiyacınız varsa ve bu döngü sırasında if else ile bir sartlı duruma ihtiyacınız varsa
     *      bu durumda for + if else kullanmak yerine while kullanabilirsiniz.
     */

    var number = 0
    while (number < 5) {
        print("${number++}, ")
    }
    println()

    number = 0
    while (number < 5) {
        print("$number, ")
        number++
    }
    println()

    for (value in 0 ..< 10) {
        if (value < 5) {
            print("$value, ")
        } else {
            break
        }
    }
}