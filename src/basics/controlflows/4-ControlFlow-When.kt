package basics.controlflows

fun main() {

    /**
     *      switch case'lerin yerine gelmiştir.
     *      when(karşılaştırılacak_ifade){
     *          value -> {}
     *          value -> {}
     *          else -> {}
     *      }
     *      formatında kullanılır.
     *      Yine {} arasına tek bir satır kod yazılacaksa bu durumda {}'leri kullanmayabilirsiniz.
     *      "tr", "az" gibi aynı kodu çalıştıracak case'ler varsa araya virgül koyarak kullanılabilir.
     *      Bu "veya" kullanımı yapmayı sağlar. "tr veya az" gibi.
     */

    val countyCode = readLine()!!
    when (countyCode) {
        "tr", "az" -> println("Türk Vatandaşı")
        "fr" -> println("France Vatandaşı")
        "ru" -> println("Russian Vatandaşı")
        "uk" -> println("United Kingdom Vatandaşı")
        else -> println("Bilinmiyor")
    }

    /**
     *      when'in yanına karşılaştırma ifadesi eklemeden, bunu case'lerin yanına da ekleyebilirsiniz.
     *      Bunun artısı && || and or xor gibi ifadeleri de kullanabilmemizi sağlar.
     */

    when {
        (countyCode.lowercase() == "az").or(countyCode.lowercase() == "tr") -> println("Türk vatandaşı")
    }

    // is !is ile bir classın referansı olunup olunmadığı kontorl edilir.
    val phoneNumber = 5555555555
    when(phoneNumber){
        is Long -> println("Long")
        !is Long -> println("Not Long")
        else -> println("Unknown")
    }

    // range'leri in !in şeklinde kontrol edilebilir.
    val number = 5
    when(number){
        in 0..10 -> println("[1-10]")
        in 11..20 -> println("[12-20]")
        else -> println(">20")
    }
}