package classes

/**
 *      Veri tutmak için kullanılırlar.
 *
 *      Kesinlikle primary constructor' ı olmalı ve içerisinde en az bir adet parametre içermeli. Bu parametre val veya
 *      var ile tanımlanmalı. val/var vermek, bu class' ın constructor' ından alınan parametreleri class member yapar.
 *      Bu parametreler default değer alabilirler. val/var olarak tanımlanmasının bir diğer sebebi de bu parametrelerin
 *      otomatik generate edilen fonksiyonlar içerisinde kullanılmasıdır. Class' ın bir üye fonksiyonu  class içerisinde
 *      bir değişkeni kullanmak istiyorsa bu değişken member olmalıdır.
 *
 *      Secondary constructor yazılabilir.
 *
 *      Member property ve function tanımlanabilir. (class içerisine doğrudan yazılan ifadeler)
 *
 *      Constructor' dan alınan property' lerin componentN function' ları generate edilirken, member property' lerin
 *      componentN functionları olmaz. componentN fonkisyonları destructuring için kullanılır. Bu parçalamada her bir
 *      parametre için o parametreye ait componentN fonksiyonu çağrılır. Bu parçalamanın sırası önemlidir.
 *
 *      Member property' ler copy, hashCode, equals ve toString fonksiyonları generate edilirken kullanılmazlar.
 *      Generate edilen copy, hashCode, equals ve toString fonksiyonlarının içleri otomatik olarak doldurulur. Bu
 *      fonksiyonlarda sadece primary constructor' dan gelen parametreler kullanılır, harici tanımlanan member' lar
 *      kullanılmaz.
 *
 *      hashCode, toString ve equals override edilebilir. Override edilirse kendi tanımladığımız fonksiyonlar geçerli
 *      olur.
 *
 *      Visibility modifier kullanılabilir.
 *
 *      Default olarak final' dır, open yapılamaz. Miras alınamazlar.
 *
 *      Abstract ya da open sınıfları miras alabilirler.
 *
 *      Interface implement edilebilir.
 */
data class DataClass(val name: String, val type: String, val origin: String) {
    var sex: String = "female"

    constructor(name: String, type: String, origin: String, fooProp: String) : this(name, type, origin) {

    }
}

fun main() {
    val dc = DataClass("John", "dead body", "Unknown")
    val dc2 = dc.copy(name = "Jane")       // İstenilen parametreleri değiştirilerek kopyalanabilir.
    val (name, type, origin) = dc       // Destructuring declaration, bu işlem içerisinde aşağıdaki işlem gerçekleşir.
    val name2 = dc2.component1()        // name değerini almanın bir diğer yolu.
    val type2 = dc2.component2()
    val origin2 = dc2.component3()
    println(dc)     // sex parametresi ekrana yazılmaz.
    println("name: $name, type: $type, origin: $origin")
}