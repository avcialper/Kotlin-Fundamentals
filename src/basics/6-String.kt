package basics

import java.util.*

fun main() {
    /**
     *  Yaklaşık olarak her karakter başına 2 byte yer kaplar.
     *  UTF-16 encoding .
     *
     *  Çift tırnak içerisinde yazılan karakter bütünüdür.
     */

    val name = "KeKod"

    for (char in name) {
        print(char)
    }
    println()

    val firstCharOfName = name[0]   // 0 yerine başka bir sayı yazılabilir. (0 ile kelime uzunluğu - 1 aralığı)
    val firstCharOfName2 = name.first()
    val firstCharOfName3 = name.indices.first

    val lastCharOfName = name[name.lastIndex]
    val lastCharOfName2 = name.last()
    val lastCharOfName3 = name.indices.last

    /**
     *      String'ler immutable'dir. Bir String ilk değer ataması yapıldıktan sonra değerini
     *      değiştiremez ya da yerni bir değer set edilemez. String üzerinde yapılan bütün işlemler
     *      yeni bir String object dönecektir.
     *      String'in ilk hali değişmeyecektir.
     */

    /**
     *      Farklı tipteki bir değişkenin önüne String bir değişken ya da ifade koyarak toplarsaniz, sonuç String olacaktır.
     *      Ancak String ifade işlemin sonuna eklenirse farklı tipte bir değişken eklenmiş olur. Kod çalışmaz
     */

    val stringNumbers = "numbers" + (4 + 2 + 8) // Çıktı numbers14
    // val stringNumbers2 = (4 + 2 + 8) + "numbers"    // Hata verir

    /**
     *      String template
     *      String ifade içerisine istenilen değeri eklememizi sağlar.
     *      $ ile direkt eklenebilir. Eğer değiişkenin farklı bir özelliğine erişmek istenirse
     *      (bir nesnenin bir özelliği gibi) ${} şeklince kullanılabilir.
     */

    val love = "love"
    val templateString = "made with $love"
    val templateString2 = "length of \"love\" ${love.length}"

    /**
     *      3 tane çift tırnak kullanarak Raw String (Multiline String) oluşturulabilir.
     *      Raw String'ler IDE'ye nasıl yazılıyorsa öyle kullanılır. Hizalamada bozulma olmaz.
     *      trimIndent() fonksiyonu ile bu Raw String'in kenar boşluklarını silebiliriz.
     *      Bu silme işlemi yapılırken tüm satırlardaki en soldaki karakteri baz alarak silme işlemini sağlar.
     *      Alttaki örnek için 3 satırdan da $ isaretinin solundaki boşluğa kadarini siler.
     *      Raw String içerisinde escape karakterler çalışmaz! Bunun için aşağıda farklı kullanımı var.
     */

    val rawPineTree = """
                *
     $         ***
              *****
    """.trimIndent()
    println(rawPineTree)

    /**
     *      trimMargin(marginPrefix) ise verilen karakter ne ise, String satırlarındaki o karaktre kadar olan kısmı siler.
     *      Yukarıdan farklı olarak bu karakter tek bir satirda ise sadece o satırın, o karaktere kadar olan kısmı silinir.
     */

    val rawPineTreeTrimMargin = """
           $    *
      $        ***
          $   *****
    """.trimMargin("$")
    println(rawPineTreeTrimMargin)

    /**
     *      Raw String içerisinde escape karakterlerini kullanmak istersek bunlar ${} içerisinde belirtmeliyiz.
     *      Raw String \ (backslash) karakterini algılamaz, normal string olarak kullanır.
     */

    val madeWithLove = """
        Made${"\t"}With${"\t"}Love
    """.trimIndent()
    println(madeWithLove)

    /**
     *      String.format(), belirli bir string içinde yer tutucuları belirtilen değerlele değiştirerek yeni bir string
     *      oluşturmamıza olanak tanır. Yer tutucular, formatlama belirtimleriyle tanımlanır ve bu belirtmeler,
     *      değiştirilecek değerlerin nasıl biçimlendirileceğini kontrol eder.
     *
     *      %s -> String için
     *      %d -> Tam sauı (Integer) için
     *      %f -> Kayan noktalı sayı (Float/Double) için
     *      %n -> Yeni bir satıra geçmek için (platform bağımsız)
     */

    val intVal = 30
    val intMessage = String.format("Integer Val %d", intVal)
    println(intMessage)

    val doubleVal = 1.7545
    val doubleMessage = String.format("Double Val %.2f", doubleVal)
    println(doubleMessage)

    val stringVal = "kotlin"
    val stringMessage = String.format("String Val %s", stringVal)
    println(stringMessage)

    val totalValMessage = String.format("Integer: %d, Double: %.2f, String: %s", intVal, doubleVal, stringVal)
    println(totalValMessage)

    // Formatlamayı bir dile göre yapmak istersek önce dili sonrasında ise %, ü kullanmamız lazım
    val price = 1234567.89
    val formattedPrice = String.format(Locale.US, "US formatında %,.2f", price)
    println(formattedPrice) // US formatında 1,234,567.89

    // TR locale oluşturma
    val localeTR = Locale("tr", "TR")
    val formattedTRPrice = String.format(localeTR, "%,.2f", price)
    println(formattedTRPrice)   // 1.234.567,89

    // String içerisinde assigment yapılamaz. Sadece expression bulunabilir.
    val assigment = 20
    // val assigmentString = "assigment + 10 = ${assigment += 10}"  // hata verir.
}