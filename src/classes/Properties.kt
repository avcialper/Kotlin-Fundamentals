package classes

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street
    result.city = address.city
    result.state = address.state
    result.zip = address.zip
    return result
}

class Person(var name: String, var surname: String) {

    // Custom getter setter yazılan değişkenlerin getter ve setter fonksiyonları değişken ile alakalı olmalıdır.
    val fullName: String
        get() = "$name $surname"
    /*
    // val olduğu için set fonksiyonu yazamayız.
    set(value) {
        field = "Jane Doe"
    }
     */

    var firstCharsOfNameAndSurname: String = "**"
        get() = "${name.first().uppercaseChar()}${surname.first().uppercaseChar()}"
        private set     // set fonksiyonunu private yaparak var değişkenin val gibi davranmasını sağlıyoruz.

    /**
     *      Field property' nin arka planda sakladığı değeri doğrudan temsil eder.
     *      Eğer biz set işlemi için değişkenin kendisini kullanmak isteseydik, değişken sürekli olarak kendi set
     *      fonksiyonunu çağıracaktı (recursive function). Aynı şekilde get içinde.
     *
     *      var propertyName: Type
     *          get(){
     *              /*
     *                  Bu kullanım hatalıdır. Burada yapılan şey yine propertyName değişkeninin get fonksiyonunu
     *                  yani şuan bulunduğu alanı çağırmasıdır. Recursive function.
     *                  Bunun yerine filed kelimesi kullanılamlıdır. Bu arka planda değişkenin değerinin tutulduğu
     *                  yapıdır. Eğer bunu kullanırsak direkt olarak memory' den değeri alır geliriz, onu getiren
     *                  fonksiyonu çağırmayız.
     *
     *                  Aynı şey set içinde geçerlidir.
     *                  fonksiyon içerisinde return propertyName denilirse yine set fonksiyonu çağırılır.
     *              */
     *              return propertyName
     *              return filed    // doğru kullanım
     *          }
     *
     *      Bir değişkenin backing-filed' a sahip olabilmesi için başlangıçta bir değer atanmasına ihtiyacı vardır
     */
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
            // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }
        get(): Int {
            return field
            //  return counter  // Sürekli counter' ın get fonksiyonunu çağırır ve StackOverflow hatası verir. Recursive
        }


    /**
     *      Bu değişken ilk değer atamasına sahip olmadığı için backing-filed' a sahip değildir.
     *      Bu yapı bir state' e sahip değildir yani memory' de alan kaplamaz. (bir değeri yok)
     *      get ile çağırıldığı zaman fonksiyonu tetiklenir, işlemeri yapar sonrasında fonksiyon içerisindeki
     *      değişkenler silinir.
     */
    val isEmpty: Boolean
        get() {
            return counter == 0
            //  return field == 0   // backing-filed' a sahip olmadığı için filed kullanılamaz.
        }

}

/**
 *      Backing-filed' a sahip yapılar extend edilemezler.
 *      printName' e bir ilk değer ataması yapılmamış, val olduğu için set fonksiyonu yazılamaz. Bu yüzden arka planda
 *      backing-filed' ı oluşturulmaz.
 *      Aşağıdaki iki yapı aslında aynı işlemi yaparlar.
 *      Teknik olarak printName kullanıldığı zaman teknik olarak printName2 extension function' ı kullanılır
 */
val Person.printName: String
    get() = this.name

fun Person.printName2(): String {
    return this.name
}

/**
 *      Aslında burada sadece bir adet backing-filed var, yani arka planda sadece bir değişken tanımlanmış.
 *      table olarak tanımlanan property herhangi gir backing-filed' a sahip değil. Sadece _table değişkenini
 *      public' e açıp herhangir bir yerde sadece get edilebilmesini sağlıyor. Yani _table değerini değiştirme işlemi
 *      hala private olarak tutulduğu alanda ama ulaşım herkese açık.
 */
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

/**
 *      Normal val değeri run-time olduğu zaman atanır, const val ise direkt olarak compile-time da çalışır.
 *      Değişkenin tipini compile-time' da öğrenir.
 */
const val constant = "constant"

/**
 *      Kotlin' de bir değişken oluşturulurken aşağıdaki syntax kullanılır;
 *      var <propertyName>[: <PropertyType>] [= <property_initializer>]
 *          [<getter>]
 *          [<setter>]
 *
 *      Bir property' nin mutable mı read-only mi olduğunu belirleyen val var keyword' leri, property ismi, isteğe
 *      bağlı olarak tipi (type inference), varsa başlangıç değeri ve bu property için oluşturulmuş get ve set
 *      fonksiyonları. Aslında biz property' lerin değerini almak veya güncellemek için arka planda oluşturulan get ve
 *      set fonksiyonlarını kullanıyoruz. (Eğer property val ile tanımlamış ise read-only özelliğinden dolayı arka panda
 *      set fonksiyonu oluşturulmaz.)
 */

fun main() {
    val address = Address()
    val person = Person("John", "Doe")

    println(person.fullName)
    // person.fullName = "asd"  // val değişken ve setter fonksiyonu tanımlanamıyor.

    println(person.firstCharsOfNameAndSurname)
    // person.firstCharsOfNameAndSurname = "AA"     // değişken var olmasına rağmen set fonksiyonunu private yaptığımız reassignment yapamayız.

    /**
     *      Fonksiyon içerisinde oluşturulan değişkenler üye değişkenler değillerdir. Üye değişkenler class' lar
     *      içerisinde oluşturulan değişkenlerdir.
     *      Biz üye olmayan değişkenlere get ve set fonksiyonları yazamayız. (local değişkenler)
     *      Fonksiyon içerisinde oluşturulan değişkenler zaten birer backing-filed' lardır.
     *      Üye değişkenler ise backing-filed' lara bağlı olan fonksiyonları barındıran yapılardır.
     *
     *      Local değişkenlere neden get set yazılamaz;
     *          - Bu değişkenler zaten bir fonksiyon içerisinde tanımlanmışlardır ve bu yüzden dışarıdan bu değişkenlere
     *          ulaşım yoktur. Fonksiyon çağırıldığında create edilirler ve fonksiyon bitince görevlerini sonlandırırlar.
     */
    var sample: String = "asd"
    /*
        get() = "asd get"
        set(value){
            field = value
        }
     */

    println(person.isEmpty)
    person.counter = 15
    println(person.counter)
    println(person.isEmpty)
}