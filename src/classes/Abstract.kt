package classes

/**
 *      Eğer ki en üstte spesifik detaylara girmeden sadece genel betimleme yapılıyorsa bunun için abstract kullanılmalı.
 *      Bir class için şablon niteliğindedirler. Yani x bir abstract property' si var ama içeriği yok. x property' si
 *      subclass içerisinde kesin olmalı ve içeriğini kendisi belirlemeli.
 *
 *      open class ile abstract class farkları nelerdir?
 *          - her ikiside primary ve secondary constructor' a sahiplerdir. Ama open ile oluşturulan bir class' tan nesne
 *          oluşturulabilirken abstract class' ların bir nesnesini oluşturamayız. Aşağıda constructor' ın kullanım alanı
 *          açıklanmıştır.
 *          - Her ikisinin constructor parametreleri de default değer alabilir.
 *      open ve abstract keyword ile tanımalanan property ve function' ların kullanım farklılıkları aşağıda mevcut.
 *
 *      interface ile abstract class farkları nelerdir?
 */

/**
 *      Abstract class' lar aynı zamanda open class' lardır. Yani başka bir sınıf tarafından miras alınabilirler.
 *      Primary ve secondary constructor tanımlanabilir.
 *      Class' ın bir constructor' ı olmasına rağmen bu class' lardan bir nesne oluşturamayız. Bu constructor yardımı
 *      ile bir class' ı inject edebiliz. Örnek olarak kullanılaması gereken bir class' ı fonksiyon içerisinde oluşturmak
 *      yerine dışarıdan constructor ile alabiliriz. Sonuç olarak constructor' dan val veya var ile aldığımız parametreler
 *      class' ın üye değişkeni olarak davanırlar ve class' ın herhangi bir yerinde kullanılabilirler.
 *
 *      Abstract class' ın içerisinde abstract property' ler ve abstract function' lar zorunlu olarak override edilmeli.
 *      Class içerisinde open property ve function' larda da tanımalanabiliyor, bunları override etmemiz zorunlu değildir.
 *
 *      Open class' larda miras alınan class' tan override edilen bir property veya function' ı kendi subclass' ımızda
 *      override edilmesini engellemek istersek başına final koymamız yeterli ooluyordu. Bu kullanım abstract property ve
 *      function' lar için geçerli değildir. Override edilen bu yapıların başına final yazamayız.
 *
 *      Abstract property ve function' lar sadece abstract class' lar içerisinde tanımlanabilir.
 */
abstract class AbstractClass(val foo: Foo = Foo(), val poo: Poo) {

    /**
     *      override edilmesini istediğimiz değişkenleri abstract ile belirtebiliriz.
     *      abstract ile tanımlanan değişkenlere ilk değer ataması yapılamaz. open ile tanımlanan değişkenlere ilk değer
     *      ataması yapabiliyorduk ama abstract' lara bunu yapamıyoruz.
     *      Abstract class' ların detay bilgi içermemesi gerektiği en başta bahsedilmişti. Bu yüzden abstract bir
     *      değişkende detay bilgi içermemeli. Sadece böyle bir değişkenin olduğu bilinmeli içeriği verilmemeli.
     */
    abstract val name: String
    abstract var surname: String
    open val age: Int = 99

    // foo nesnesini constructor' dan alarak kullandık, yeni bir nesne oluşturmadık.
    fun boo() {
        foo.printFoo()
    }

    /**
     *      Abstract function' lar bir body' e sahip olamaz. Yine abstract' ın ana görevi olan özelliği belirtir ama
     *      detay verme durumundan dolayı. Diğer class' lar böyle bir işleve sahipler ama her class kendi özelliğine
     *      göre bu işlemi farklı şekillerde gerçekleştirebilirler.
     */
    abstract fun loo()
    open fun soo() {}

    /**
     *      Abstract function' lar parametre alabilirler. Alıdkları parametreler override edildiği yerde de alınmalıdır.
     *      Aynı zamanda bu fonksiyon parametrekerine default argument verebiliriz.
     *      Yine open function' larda olduğu gibi bu parametreler override edildiği yerde default değer alamaz.
     */
    abstract fun goo(type: String = "asd")
}

/**
 *      Abstract class' lar başka abstract class' ları miras alabilirler. Miras alınan sınıf constructor' değer bekliyorsa
 *      bunlar verilmeli.
 *      Abstract class' lar miras aldıkları abstract class' ların, abstract ile tanımlı property ve function' larını
 *      override etmek zorunda değillerdir.
 *
 *      Open class, abstract class' tan miras aldıysa abstract property ve function' ları override etmek zorundadır.
 */
abstract class SecondAbstract(foo: Foo, poo: Poo) : AbstractClass(foo, poo) {
    abstract val voo: String

    override val name: String
        get() = "John"
}

/**
 *  Eğer miras alınan abstract class' ın da miras aldığı abstract class' lar varsa; miras alınan sınıfların zorunlu
 *  override edilmesi gereken property ve function' lar yani abstract property ve function' lar varsa ve bunlar üst
 *  sınıflarda override edilmemişse burada mecburi olarak override edilir. Eğer bu abstract property veya function' lar
 *  miras alınan sınıfların birinde override edilmiş ise bu zorunluluk ortadan kalkar. İstersek bunları yine override
 *  edebiliriz.
 *
 *  Burada name AbstractClass class' ının içerisinde abstract olarak tanımlanmış olmasına rağmen SecondAbstract içerisinde
 *  override edldiği için bu class içerisinde override edilmesi mecbur değildir. Ama surname, loo() ve goo() SecondAbstract
 *  içerisinde override edilmediği için mecburi olarak burada override edilmeli.
 */
class ThirdClass() : SecondAbstract(Foo(), Poo()) {
    override var surname: String = "Doe"
    override val voo: String = "voo"

    override fun loo() {
        TODO("Not yet implemented")
    }

    override fun goo(type: String) {
        TODO("Not yet implemented")
    }
}

class Foo() {
    fun printFoo() {
        println("foo")
    }
}

class Doo(poo: Poo) : AbstractClass(poo = poo) {
    override val name: String
        get() = "John"

    // fonksiyonlarda filed kullanmak istersek başlangıç değeri atamalıyız. Bu sayede bir backing-field' a sahip oluruz.
    override var surname: String = "Doe"
        get() = field
        set(value) {
            field = value
        }

    override fun loo() {
        println("loo")
    }

    // type' a default değer veremeyiz.
    override fun goo(type: String) {
        println("type: $type")
    }
}

class Poo

fun main() {
    val poo = Poo()
    val doo = Doo(poo)
    println(doo.name)
    println(doo.surname)
}
