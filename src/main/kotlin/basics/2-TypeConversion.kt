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

    /**
     *      Numbers.kt içerisindeki değişken tiplerinin değer aralıklarını inceleyiniz.
     *      Değer aralığı büyük olan tipler küçük olan tiplere açık olarak (explicit) dönüştürülürken dikkatli olunalı.
     *      Üst tipten bir değişkenin değeri, alt tipin değer aralığından pozitif yönde fazla büyük.
     *      Negatif yönde fazla küçük ise bu tip dönüşümü sırasında yanlış değer atamaları yapılmaktadır.
     */

    val tcIdentityNumber = 15_860_826_657
    val convertedInt = tcIdentityNumber.toInt()
    println("convertedInt $convertedInt")


    /**
     *      Kapali (implicit) tip dönüşümü olmasa bile, iki number tip arasında matematiksel işlem yapılırsa, sonuç değeri
     *      çıkan değerin tipinde olacaktır.
     */

    val totalValue: Long = tcIdentityNumber + schoolNumber  // Long + Byte = Long
    val longNumber = 2_100_000_000
    val dividedNumber = 2_100_000_000
    val resultNumber = longNumber + dividedNumber

    /**
     *      Kotlin'in sağladığı yukarıdaki tip dönüşümlerinin yanında, String to Number dönüşümleri için Java'dan
     *      aşina olduğumuz tip dönüşümlerini de kullanabiliriz.
     *      Bunun için ilgili tiplerin Java versiyonlarını kullanmalisiniz.
     */

    val byte: String = "3"
    val intValue = Integer.parseInt(byte)
}