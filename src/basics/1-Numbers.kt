package basics

fun main() {

    /**
     *      Type        Size (bits)
     *      ------------------------------------------------------------------------------------------------------------
     *      Byte        8 bit
     *      Short       16 bit
     *      Int         32 bit
     *      Long        64 bit
     *
     *      Bu değerlerin unsigned halleride mevcut. Unsigned değerlerde negatif ifade bulunmaz. Byte signed olarak
     *      127 / -128 aralığındadır ama unsigned olarak  0 / 255 aralığındadır.
     *
     *      Float       32 bit
     *      Double      64 bit
     *
     *      Double da noktadan sonra basamak sayısı daha fazladır.
     *
     *      ------------------------------------------------------------------------------------------------------------
     *
     *      Type Inference kullanılıyorsa atanan değer Int'in değer aralığında ise IDE otomatik olarak Int tipi alır
     *      (Byte ve Short aralığında olsa bile Int olarak kabul edilir.).
     *      Eğer değer Int'in değer aralığında değilse de Long olarak alır. En optimal sonucu
     */

    // Sayılarda underscore _ kullanılabilir. Okunurluğu arttırır.

    /**     -------------------------------- ÖNEMLİ -----------------------------------
     *
     *
     *      Boxed   : Değişkenin obje referansı olarak tutulmasıdır.
     *      Unboxed : Değişkenin primitive olarak tutulmasıdır.
     *      === operatörü değişkenlerin referansını karşılaştırıken kullanılır.
     *      ==  operatörü değişkenlerin değerini karşılaştırırken kullanılır.
     *
     *
     *      Bir değişkenin nullable olarak tanımlanması onun primitive olmasını engeller. Referans olarak tutulur
     *      val number: Int = 500             // primitive
     *      val nullableNumber: Int? = 500    // class
     *
     *      Bu iki değeri == ile karşılaştırırsak true değerini elde ederiz. Eğer === ile karşılaştırırsak false cevabını
     *      alırız. Çünkü === ile adres katşılaştırması yapıyoruz. Bir adreste sadece bir değer olabilir.
     *
     *      Eğer number değişkeni -128 ile 127 aralığında olsaydı === kontrolü doğru çıkacaktı. Kotlinde yapılan
     *      optimizasyonlar ile Byte aralığındaki sayılar değer ve referans olarak eşitlerdir.
     *
     *      primitive ve class tipleri arasında hafızada kapladığı alan ve erişme hızları farklıdır.
     */

    val number: Int = 10
    val boxedNumber: Int? = number
    val anotherBoxedNumber: Int? = number
    println(boxedNumber === anotherBoxedNumber)     // true, değer byte aralığında

    val number2: Int = 1500
    val boxedNumber2: Int? = number2
    val anotherBoxedNumber2: Int? = number2
    println(boxedNumber2 === anotherBoxedNumber2)   // false, değer byte aralığı dışında

}