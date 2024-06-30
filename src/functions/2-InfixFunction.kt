package functions

fun main() {

    /**
     *      Daha okunaklı kodlar yazmak için kullanılır.
     *      . (nokta) ile veya noktasız kullanılabilir.
     *      Bir fonksiyonu infix hale getirebilmek için 5 şart vardır.
     *          - infix keyword'ü ile başlar
     *          - fonksiyon bir üye fonksiyon olmalıdır (bir sınıfa ait olmalıdır)
     *          - ya da bir extension function olmalıdır
     *          - sadece bir parametre almalıdır, bu parametre vararg olamaz
     *          - parametre default değer alamaz
     *
     *      infix fun ValueType.funName(param: Param): ReturnType: {
     *          ...
     *      }
     */

    val isStudent = true
    val isMale = true

    //  and, or, xor gibi birçok infix function vardır.

    if (isStudent == isMale) {
        println("Erkek öğrenci")
    }

    //  infix function
    isStudent and isMale
    isStudent.and(isMale)

    val firstName = "John"
    val lastName = "Doe"
    val conceitedStrings = firstName.concat(lastName)
    val conceitedStrings2 = firstName concat lastName

    val awesomeInstance = AwesomeClass()
    awesomeInstance downloadImage "www.google.com"
    awesomeInstance.downloadImage("www.google.com")

    /**
     *     matematiksel operatörlerin ,tip dönüşümlerinin (type conversion), range kullanımın, infix methodlara
     *     karşı işlem önceliği vardır.
     */
    val number = 5
    if (number + number - 2 * (awesomeInstance specialPlus 4) == 5) {
        println("== 5")
    }

    // infix methodların da mantık operatölerine göre önceliği vardır
    if (number == 3 && number < 5 || awesomeInstance specialPlus 4 == 5) {

    }
}

// İki string ifadeyi birleştirme
infix fun String.concat(otherWord: String): String {
    val result = this.plus(otherWord)   // this burada fonksiyonun solundaki String'i belirtir.
    return result
}

class AwesomeClass() {

    // Kendi instance'ı ile çalışır
    infix fun downloadImage(imageURL: String) {

    }

    infix fun specialPlus(number: Int): Int {
        return 4
    }

    // Default parametre verilemez
    // infix fun defaultArg(arg: String = "default"){}

    // vararg parametre verilemez
    // infix fun varargFun(vararg args: String){}

    //  Bir sınıfın içerisindeyken this kullanımı size bulunduğu class'ı işaret eder.
    //  Aşağıdaki aslında AwesomeClass().downloadImage(imageURL) kullanımı oluşur (implicit)
    fun logWhenImageDownloaded(imageURL: String) {
        // Hepsi aynı.
        downloadImage(imageURL)
        this downloadImage imageURL
        this.downloadImage(imageURL)
        //  downloadImage imageURL  // Kullanılamaz.
    }
}