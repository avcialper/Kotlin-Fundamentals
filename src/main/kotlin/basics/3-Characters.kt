package basics

fun main() {
    /**
     *  16 bit yer kaplarlar.
     *
     *  Tek tırnakların arasına harf, sayi, escape char ya da unicode yazarak kullanılır.
     */

    val firstCharOfName = 'A'
    val firstCharOfSurname: String = "A"    // Çift tırnak olduğu için String'dir

    val charNumber: Char = '6'

    /**
     *  Number değer alan bir Char değişken Int'e çevirilirken, gerçek sayısal değerini almaz.
     *  Alacağı değer ASCII tablosundaki o sayısal değerin karsılığı olacaktır.
     */
    val convertedCharNumber = charNumber.code   // 6 değerinin ASCII karşılığı 54
    val digitToInt = charNumber.digitToInt()    // Sayı belirten Char değerini Int'e çevirir

    println("charNumber = $charNumber")     // 6
    println("convertedCharNumber = $convertedCharNumber")   // 54
    println("digitToInt = $digitToInt")     // 6

    /**
     *  Unicode karakterler kullanılabilir
     *  İfadenin \u ile başlaması bir unicode olduğunu belirtir. Bu sayede tek tırnak içerisine yazılabilir.
     *
     *  Kelimeler farklı renkler ile kullanılabilir.
     */
    val blackHeart = '\u2665'
    println("blackHeart: $blackHeart")
}