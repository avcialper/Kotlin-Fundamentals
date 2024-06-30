package functions

import java.util.*

fun main() {

    /**
     *      fun keyword'ü ile fonksiyonlar başlar.
     *      fonksyion ismi verilir.
     *      parametre parantezleri açılır ve parametreler girilir.
     *      : operatörü ve geri dönüş değeri yazılır.
     *      fonksiyonun body'si açılır ve kapatılır.
     *      Geri dönüş değeri verilmeyen fonksyionlar Unit tipini geri döndürür.
     *
     *      Neden Nothing değilde Unit? Eğer geri dönüş tipi Unit olursa herhangi bir şey return etmemiz istenilmez.
     *      Ama geri dönüş tipi Nothing olursa geriye bir değer döndürülmesi istenir.
     *
     *      Fonksiyon çağırılıken ismi ve parametreleri kullanılır.
     *      Eğer bir geri dönüşü varsa bir değişkene atanabilir.
     */

    takeSquare(2)
    val square = takeSquare(2)
    println("square is: $square")

    // Bir class'ın fonksiyonunu çağırırken ise nokta işareti kullanırız.
    Math.pow(2.0, 3.0)

    /**
     *      Default değeri olan parametrelere sahip bir fonksiyon çağrılırken, default değeri olan parametrelere değer atamak
     *      şart değildir. Default değeri olan bu parametreler opsiyonel parametrelerdir.
     *      Default değeri olan parametreye değer atanmadan fonksyon çağrılacaksa bu durumda parametre sırası değişir.
     *      IDE'ye hangi parametreye değer atadığınızı söylemek için Named Arguments' leri kullanmazız gerekir.
     *
     *      Verilen default değerlere Default Arguments, fonksiyona parametre hangi değere verildiğini belirtmeye
     *      Named Arguments denir. Bu şekilde tanımlanan fonksiyonlar Java'daki overload fonksiyonlara karşılık gelir.
     */
    reformatMessage("Message", true, 7, "tr")
    reformatMessage(message = "Message", isUpperCase = true, size = 7, lang = "tr") // Named arguments
    reformatMessage("Message", true, 7) // lang olarak default value kullanılacak
    // Burada named argument kullanılmazsa ide değerleri sırayla gönderir, size değerini boolean olarak algılar
    reformatMessage(message = "Message", size = 7, lang = "en")
    reformatMessage("Message", size = 7)

    // key = 3 den önceki parametreler vararg parametresine denk gelir.
    getUserInfo("Alper", "Avcı", "Antalya", "Türkiye", "", "", "", key = 3)

    // vararg parametresi olarak array verilmek istenirse * (spread operator) kullanılmalıdır.
    // Bu operatör pointer kullanımına denk gelmez. Kotlin'de pointer yoktur.
    getUserInfo(*arrayOf("Alper", "Avcı", "Antalya", "Türkiye"), key = 3)

    getUserInfo2("Alper", "Avcı", "Antalya", "Türkiye")

    getUserInfo3(3, "Alper", "Avcı", "Antalya", "Türkiye")

    getUserInfo4("Alper", "Avcı", "Antalya", "Türkiye", true, 20)
}

// Fonksiyon parametesi tanımlanırken, val var gibi betimleyiciler kullanılmaz.
fun takeSquare(number: Int): Int {
    return number * number
}

/**
 *      = ile fonksiyonlara default değer verilebilir. (Default Argument)
 *      Default değer atamaı yapmak function overload işlemi yapmamızı sağlar.
 *      Tekrar tekrar aynı fonksiyonun farklı varyasyonlarını yazmak durumunda kalmayız.
 */
fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {

    val locale = if (lang == "tr") {
        Locale("TR", "tr")
    } else {
        Locale.ROOT
    }

    val localeMessage = if (isUpperCase) {
        message.uppercase(locale)
    } else {
        message.lowercase(locale)
    }

    println("Message : $localeMessage, isUpperCase: $isUpperCase, size : $size, lang: $lang")
}

/**
 *      Çok fazla sayıda parametreniz olacaksa "variable number of arguments" - vararg tanımlanabilir.
 *      Bu sayede fonksiyon tek bir parametre alıyor gibi gözükürken kendisine çok miktarda değişken atanabilir.
 *      Bu değişkenlere array'e erişir gibi erişebiliyoruz.
 *
 *      vararg tek ya da son parametre olarak yazılırsa, JVM'e hazırlanırken Java'daki "String..." gibi aynı kod derlenir.
 *      Ancak vararg param birden fazla tanımlanırken ortada ya da basta yer alırsa, JVM'e hazırlanırken, Array'e dönüştürülür.
 *      Bu da performans kaybına neden olur.
 *
 *      Aynı fonksiyon parametre olarak birden fazla vararg alamaz. İzin verilmez.
 */
fun getUserInfo(vararg userInfo: String, key: Int) {
    userInfo[key]
}

fun getUserInfo2(vararg userInfo: String) {
    userInfo[2]
}

fun getUserInfo3(key: Int, vararg userInfo: String) {
    userInfo[key]
}

fun getUserInfo4(vararg userInfo: Any) {
    userInfo[3]
}

/**
 *      Default değeri olan parametrelere sahip bir fonksiyon Java sınıflarından çağrılacaksa eğer,
 *      bu fonksiyona @jvmOverloads annotation' ı verilmelidir. Böylece yazılan kod JVM'e hazır hale getirilirken,
 *      ilgili fonksiyonun tüm varyasyonları yazılır (overload edilir).
 */
@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}

/**
 *      Extend edilebilir bir sınıf, yavru (child) sınıfı tarafından miras (inherit) alnırsa ve bu sınıfın override
 *      edilebilir open bir methodu varsa, bu method default argument'e sahip olursa, bu sınıfı miras alan sınıfda method
 *      override edilirse, override edilen methodun parametresine default argument üst sınıfın methodu'undaki default
 *      argument geçerl olur.
 *
 *      Eğer super class'ta ki fonksiyon default argument'a sahipse ve child class bu fonksiyonu override ederse,
 *      override edilen fonksiyonun default parametreleri super class'taki default parametrelerdir.
 *      Override edilen fonksiyona yeni bir default değer ataması yapılamaz.
 */
open class A {
    open fun foo(i: Int = 10) {

    }
}

class B : A() {
    override fun foo(i: Int) {      // Yeni default argument verilemez.
        super.foo(i)
    }
}

/**
 *      Bir fonksiyona = koyularak da return edeceği değer yazılabilir. (Single-Expression)
 */
val userList = arrayOfNulls<String>(5)

fun getListCount(): Int = userList.size

fun getListCount2() = userList.size     // inferred

fun getListCount3(): Int {
    return userList.size
}