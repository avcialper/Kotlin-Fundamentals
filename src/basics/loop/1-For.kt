package basics.loop

fun main() {

    /**
     *      3 farklı şekilde for tanımlanabilir;
     *      value in list                       şeklinde value değerleri
     *      index in list.indices               şeklinde index depğerleri
     *      (index, value) in list.withIndex()  şeklinde index, value değerleri alınabilir.
     */

    for (value: Int in 1..10) {
        print("$value ")
    }
    println("\n-----------------")

    val countryCodeArray = arrayOf("tr", "az", "en", "fr")
    for (value in countryCodeArray) {
        print("$value ")
    }
    println("\n-----------------")

    for (index in countryCodeArray.indices) {
        print("$index. indexteki elemanın değeri ${countryCodeArray[index]}\n")
    }
    println("-----------------")

    /**
     *      withIndex() bir destructuring declarations dır. Yani bir nesneyi bir dizi ayrı değişkene ayırmak için
     *      kullanılan bir syntax'tır
     *      Burada bir diziyi index ve value olarak ayırmıştır.
     */
    for ((index, value) in countryCodeArray.withIndex()) {
        print("$index. indexteki elemanın değeri $value\n")
    }
    println("-----------------")

    /**
     *      repeat(size) şeklinde herhangi bir listeye ihtiyaç duymadan tekrarlayan işler yapılabilir.
     */

    repeat(10) {
        print("$it ")   // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    }
    println("\n-----------------")

    /**
     *      return kullanarak ilgili şart sağlanırsa donguden çıkabilirsiniz.
     *      continue kullanarak ilgili şart sağlanırsa, dongu o değeri atlayarak devam eder.
     *      break kullanarak ilgili şart sağlanınca döngüden çıkabilirsiniz.
     */

    for (value in 1..10) {
        if (value % 2 == 1) {     // Çift sayılarda ekrana yazmayı atlar.
            continue
        }
        print("$value ")
    }
    println("\n-----------------")

    for (value in 1..10) {
        if (value == 7) {         // 1-6 değerlerini ekrana yazdırır, 7 ye gelince döngüden dışarı çıkar.
            break
        }
        print("$value ")
    }
    println("\n-----------------")

    /**
     *      İç içe for döngüleri kullanıyorsak bir üstteki for'a değil de iki-üç üstteki for'a dönmek istiyorsak
     *      label kullanabiliriz. Bunun için labelname@ fadesini ilgili for'un önüne yazıp, return ya da continue
     *      yapamayacağımız yere ise @labelname şeklinde yazmamız yeterlidir.
     */

    for (value in 1..5) {
        for (value2 in 0..10) {
            if (value2 == 3) {
                continue
            }
            print("continue1 $value2 ")
        }
    }
    println("\n-----------------")

    returnLabel@ for (value in 1..10) {
        for (value2 in 1..10) {
            if (value2 == 5) {
                continue@returnLabel
            }
            print("continue2 $value2 ")
        }
    }
    println("\n-----------------")

    returnLabel@ for (value in 1..10) {
        for (value2 in 1..10) {
            if (value2 == 6) {
                break@returnLabel
            }
            print("break $value2 ")
        }
    }
}