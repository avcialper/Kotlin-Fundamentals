package classes

/**
 *      Farklı class' larda ortak olan özellikleri bir class' a toplama işlemine denilir. Aynı property' ler, aynı
 *      fonskiyonlar aynı işlemleri yapmalıdır.
 *
 *      Kotlin' de default olarak her sınıf final keyword' ü ile tanımlanmıştır. Bu da bu class' ın miras alınamayacağı
 *      anlamına gelir. Bir class' ı miras almaya açık yapmak istersek open keyword' ünü kullanmamız gerekir.
 *
 *      Class' ın property ve function' larda default olarak final' lardır. Bu fonksiyonlara subclass' lardan direkt
 *      olarak erişebiliriz ama override edemeyiz. Yani class' a özel tanımalamar yapamayız. Bunu yapabilmek için
 *      open keyword' ü ile tanımlamamız gerekmetedir.
 *
 *      Default olarak final ile tanımlanmış olmaları bu değişkenlerin fonksiyonlarının ve üye fonksiyonlarun arka
 *      planda final keyword' ü ile tanımlanmalarına sebep olur. final keyword' üne sahip fonksiyonlar subclass' lar
 *      tarafından kullanılabilirler ama override edilemezler.
 */
open class Animal(open var name: String, var origin: String) {
    final var feetCount: Int = 4
    var tailShape: String = "oval"

    // arka planda public olarak tanımlı
    open fun makASound(): String {
        return ""
    }

    // arka planda private final olarak tanımlı
    private fun eat() {

    }

    // arka planda public final olarak tanımlı
    fun walk() {

    }

    /**
     *      Open function' lar parametre alabilirler. Fonsiyonun override edildiği yerlerde de bu parametreler
     *      zorunlu olarak tanımlanmalılar.
     *      Parametre default değer alabilir. Override edildiği yerde bu değerlere default değer veremeyiz. Default
     *      değer miras alınan fonksiyonun yapısına aykırı olabilir.
     */
    open fun foo(value: String = "foo") {

    }

}

/**
 *  miras almak için : kullanılır. Animal' ın primary constructor' ında name değişkeni bekleniyor.
 *  Miras aldığımız sınıfa constructor ile parametre geçmek istersek, bu parametreleri var veya val ile belirtemeyiz.
 *  Çünkü subclass' ın nesnesini oluşturup bir değişkenine gidersek onun superclass içerisinde olduğunu görürüz.
 *  Biz bu değişkenleri val veya var ile alırsak, bunlar subclass' ın property' leri olurlar. Ama aslında bu property' ler
 *  superclass içerisiden zaten tanımlıdır.
 *
 *  Eğer superclass property' leri open olarak tanımlanmışsa ve subclass' ta override edilmişse, subclass nesnesinde bu
 *  property' lere gidilmek istenince subclass içerisine yönlendirilir.
 *
 *  subclass' ın superclass' ın property ve function' larını override etmesi dynamic polymorphism' dir.
 */

class Dog(name: String, origin: String) : Animal(name, origin) {
    override var name: String = "dog name"

    override fun makASound(): String {
        return "hav hav"
    }

    /**
     *  function overload, class içerisinde aynı fonksiyonun farklı şekillerde oluşturulması.
     *  function overload ile aynı fonksiyonun farklı sonuçlar vermesi static polymorphism dir.
     *
     *  function overload için parametreler farklı türde veya sayıda olmalı
     */
    fun call(owner: Owner) {
        owner.foo()
    }

    fun call(another: Another) {
        another.boo()
    }

    override fun foo(value: String) {

    }
}

class Owner {
    fun foo() {

    }
}

class Another() {
    fun boo() {

    }
}

/**
 *  name property' si open olduğu için ve Cat sınıfı da bunu override ettiği için name değeri Cat sınıfına ait
 *  olmuş oluyor.
 *
 *  Bu olaya polymorphizim denilir.
 *
 *  Polymorphism, farklı sınıfların, aynı isimdeki metodları veya property' leri farklı şekillerde gerçekleştirebilmesini
 *  sağlar. Yani, bir üst sınıfta tanımlanmış bir metod veya fonksiyon, alt sınıflar tarafından kendi özel
 *  gereksinimlerine göre yeniden tanımlanabilir (override edilebilir).
 *
 *  Dynamic polymorphism;
 *      - superclass' ın override fonksiyonlarının subclass' larda override edilmesi ve
 *      subclass' a uygun olarak yeniden yapılandırılmasıdır. Bu tür polymorphism' e Runtime Polymorphism de denilir.
 *      Çalışma zamanında subclass tarafından override edilen methodlar kullanılır.
 *
 *  Static polymorphism;
 *      - Aynı class' ın farklı sayıda veya aynı sayıda ama farklı türlerde parametreler alan fonksiyonlarına denilir.
 *      Bu fonksiyonlar overload edilmişlerdir. Compile-Time Polymorphism de denilir. Çağırılacak fonksiyon derleme
 *      zamanında almış olduğu parametreye göre belirlenir.
 */
class Cat(override var name: String, origin: String) : Animal(name, origin) {
    override fun makASound(): String {
        return "miyav"
    }
}

open class High() {
    open fun foo() {}
}

/**
 *      Super class' tan override edilen bir fonksiyonu kendi subclass' ına kapalı yapmak istersek yani override
 *      edilmesini engellemek istersek override fun' ın en başına final keyword' ünü eklememiz gereklidir.
 */
open class Medium : High() {
    final override fun foo() {
        super.foo()
    }
}

open class Low : Medium() {
    // Medium içerisindeki foo final keyword' ü ile tanımlandığı için override edilemez.
    // final' ı kaldırmanız halinde override override edilebilir hale gelir.
}

fun main() {
    val animal = Animal("animal", "origin")
    val dog = Dog("paşa", "sivas")
    val cat = Cat("boncuk", "van")

    dog.name
    cat.name

    cat.origin      // miras aldığı için kendi içerisinde de tanımlanıyor.
    cat.walk()      // aynı şekilde fonksiyonlar da tanımlanıyor.
}