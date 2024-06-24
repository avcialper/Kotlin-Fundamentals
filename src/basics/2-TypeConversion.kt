package basics

fun main() {

    /**
     *      Implicit Type Conversion    :   Örtülü - belirgin olmayan şekilde tip dönüşümü. Mesela Double beklenen bir
     *                                      yerde değer olarak Int gönderirsek dil bunu otomatik olarak Double türüne
     *                                      dönüştürür
     *
     *      Explicit Type Conversion    :   Açık - berligin tip dönüşümü
     *
     *
     *      Kotlin' de implicit type conversion yoktur.
     */

    // val number: Int = (Int)3L   // Çalışmaz

    // Değer aralığı küçük olan tipler büyük olan tiplere sorunsuz, açık olarak (explicit) dönüştürülebilir
    val schoolNumber = 126.toByte()
    val convertedSchoolNumber = schoolNumber.toShort()

    println("schoolNumber $schoolNumber")
    println("convertedSchoolNumber $convertedSchoolNumber")
}