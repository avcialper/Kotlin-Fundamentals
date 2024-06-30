package basics

fun main() {

    /**
     *      Sonlu sayılı liste oluşturmaya yarar.
     *
     *      Küçükten büyüğe liste oluşturmak için;
     *      ".." operatörünü ya da rangeTo() fonksiyonunu,
     *      "..<" operatorünü ya da rangeUntil() fonksiyonunu kullanabilirsiniz
     */

    val numbers = 1..100            // [1,100]
    val numbers2 = 1.rangeTo(100)   // [1,100]
    // val numbers3 = 1 rangeTo 100

    val numbersUntil = 1..<100          // [1,100)
    val numbersUntil2 = 1.rangeUntil(100)   // [1,100)
    // val numberUntil3 = 1 rangeUntil 100

    /**
     *      Char'lardan oluşan bir liste de tanımlanabilir. İngilizce alfabe kullanılır.
     */
    val alphabet = 'a'..'z'
    println(alphabet)

    /**
     *      Büyükten küçüğe .. operatörünü kullanarak liste liste oluşturamayız. IDE hata verecektir.
     *      Büyükten küçüğe liste oluşturmak için downTo() kullanabiliriz. Infix kullanımı da vardır.
     */

    val reversedNumbers = 100.downTo(1)
    val reversedNumbers2 = 100 downTo 1

    // reversed() fonksiyonu ile liste tersine çevrilebilir.
    val newReversedNumbers = numbers.reversed()

    /**
     *      until fonnksiyonu kullanılarak da range tanımlanabilir. Bitis değeri listeye dahil edilmez.
     */

    val gradeNumbers = 1.until(100)
    val gradeNumbers2 = 1 until 100

    /**
     *      step fonksiyonu ile liste oluşturulurken belirli sayıda atlamalar sağlanabilir.
     */

    val steppedNumbers = 1..100 step 2
    val steppedNumbers2 = 100 downTo 1 step 2

    /**
     *      CharRange, IntRange ve LongRange isimlerinde özel range'ler vardır. Progression olarak adlandırılır.
     *      Diğer tipler bulumaz.
     *
     *      Float ve Double da virgülden sonra artış miktari bilinmediği için, boolean yalnızca 2 değer aldığı için.
     *
     *      Bu durumda; first, last, step, count gibi ek bilgiler alınabilir.
     *      Iterable<N> interface'ini implement etmişlerdir. O sebeple map filter gibi fonksiyonları kullanabilirler.
     */

    val numberList: IntRange = 1..100
    println("numberList first ${numberList.first}")
    println("numberList last ${numberList.last}")
    println("numberList step ${numberList.step}")
    println("numberList count ${numberList.count()}")

}