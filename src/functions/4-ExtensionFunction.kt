package functions

fun main() {

    /**
     *      Üzerinde değişiklik yapamadığımız (readOnly) sınıflara ya da yapmak istemediğimiz sınıflara, bu sınıfların
     *      içerisinde yazmadan fonksiyon tanımlayabilmemizi sağlar. Böylece o sınıfa üye bir fonksiyon kazandırabiliriz.
     *      Bunu yaparken unutmamamız gereken; yazdığınız extension fonksiyon aslında o sınıfın gerçek bir fonksiyonu
     *      olmayacaktır.
     *
     *      Receiver diyer adlandıracağımız bir sınıfa ihtiyaç duyar. Extension yazacağımız sınıfı ifade eder.
     *
     *      Hiç bir zaman sınafa ait üye fonksiyonlar olmayacakları için, sınıfın private değişkenlerine erişemezler.
     *
     *      fun ValueType.awesomeFun(awesomeParam: AwesomeParam): ReturnType {
     *          ...
     *      }
     */

    /**
     *      Extension function java tarafında neye karşılık gelir. -> shift+shift-> show kotlin bytecode
     *
     *      Java'da bu işlemler yine static fonksiyonlar ile yazılabilir.
     *      Fonksiyonel programlama yaklaşımına göre extension function yazmak daha uygundur.
     */

    //  Normalde değişkenlere değer atayıp, print işlemini aşağıdaki gibi yaparız.
    val pi: Double = 3.14
    println("Double Number = $pi")

    val schoolNumber: Int = 1589
    println("Int Number = $schoolNumber")

    val tcIdentityNumber: Long = 12345678912
    println("Long Number = $tcIdentityNumber")

    //  Yukarıdaki işlemler için normalPrint adında bir fonksiyon yazılıp kullanılabilir
    normalPrint(pi)
    normalPrint(schoolNumber)
    normalPrint(tcIdentityNumber)

    normalPrint2(pi, "Double Number:")
    normalPrint2(schoolNumber, "Int Number:")
    normalPrint2(tcIdentityNumber, "Long Number:")

    pi extPrint "is Pi"
    3.14 extPrint "is Pi"   // infix olarak tanımladığımız için bu şekilde kullanılabiliyor.
    3.14.extPrint("is Pi")


    /**
     *      Extension fonksiyonun yazıldığı tip için bütün projede geçerli olması isteniyorsa, bu fonksiyon
     *      Top Level Function olmalıdır. Bir class içerisine yazılırsa sadece o class için geçerli olur... (Local Function)
     *
     *      class FooClass(){
     *
     *          fun Int.fooFun(){
     *              ...
     *          }
     *
     *      }
     *
     *      Bu extension function sadece bu class için geçerlidir.
     */
}

fun normalPrint(number: Number) {
    when (number) {
        is Int -> println("Int Number = $number")
        is Double -> println("Double Number = $number")
        is Long -> println("Long Number = $number")
    }
}

fun normalPrint2(number: Number, message: String) {
    println("$message $number")
}

/**
 *      Number (receiver) sınıfına extension olarak yazılmış extPrint fonksiyonu. Aynı zamanda infix yapılmıştır.
 *      this ifadesi, extension yapılan değeri verir.
 *      3 log "4" yaparsanız; this = 3, emptyParam = "4" olur.
 */
infix fun Number.extPrint(emptyParam: String) {
    println("$this $emptyParam")
}

/**
 *      Fonksiyon tek parametre alıyorsa infix olarak yazılabilir.
 *      Infix extension fonksiyon expression formunda kullanılabilir.
 */
infix fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()

class ExtClass() {
    private var name = "kotlin"

    fun classPrint() {
        this.name       // Üye fonksiyonu olduğu için doğrudan private değişkenlere erişilebilir.
    }
}

fun ExtClass.printName() {
    //  this.name   // name değeri private olduğu için erişilemez.
}

open class Shape() {
    var intNumber = 0

    open fun Int.extToString() {

        // Int.extToString
        extToString()
        // fun extToString
        this@Shape.extToString()

        println("shape class print")
    }

    fun extToString() {
        println("member fun print")
    }
}

/**
 *      Bir sınıfa extension function yazılabildiği gibi extension property de yazılabilir.
 *      Bunun sebebi aslında property'lerin get() ve set() methodlarından oluşmasından dolayıdır.
 *      Bu extension property'leri içerisinde field tanımlamaz.
 *      Dolayısıyla aslında gercek anlamda bir değişken extension yapılamaz.
 *      Bu konu property vs field konusu ile beraber sınıflarda işlenirken detaylı anlatılacaktır.
 *
 *      Property aslında bir fonksiyondur. Ama backing field'i olmayan bir fonksiyon olarak extend edilebilir. ??!!
 */
/*
var Shape.type: String
    get() = type
    set(value) {
        type = value
    }
*/

// Bu iki fonksiyon yukarıdaki kullanıma karşılık gelmektedir.
/*
fun Shape.getType(): String {
    return type
}

fun Shape.setType(type: String) {
    this.type = type
}
 */

//  var Shape.type = 5  //  Yapılamaz

/**
 *      Open (extend edilebilir) bir sınıfa, sınıfın içinde bir open (override edilebilir) extension fonksiyon yazılırsa
 *      bu sınıfı miras (inherit) alan sınıflar, ilgili extension fonksiyonu override edebilirler.
 */
class Rectangle : Shape() {
    override fun Int.extToString() {
        println("rectangle extToString")
    }
}