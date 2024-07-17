package classes

/**
 *      Gruplanabilen, benzer tiplere sahip veri tutmak için kullanılır.
 *      Enum sabitleri, enum class' ı miras alan static class' lardır.
 *
 *      Default olarak final' lardır.
 *      Enum sabitleri, static class oldukları için nesneleri üretilemez.
 *
 *      Başka sınıflar tarafından miras alınamazlar, kendileri de miras almaz.
 *      Nesnesi oluşturulamaz, primary ve secondary constructor' lar private olarak tanımlanmışlardır. Private dışında
 *      erişim belirleyici alamazlar.
 *
 *      Visibility modifier kullanılabilir.
 *      primary (init bloğu içerir) ve secondary constructor tanımlanabilir.
 *      interface implement edilebilir. Eğer implement edilen interface içerisindeki fonksiyonlaru enum class tarafından
 *      override edilmemiş ise, enum sabitlerinin hepsi bu fonksiyonları override etmek zorundadılar. Eğer enum class
 *      override etmişse, enum sabitleri isteğe bağlı olarak override edebilirler.
 *      İçerisinde function tanımlanabilir. Abstract olarak tanımlanan bir fonksiyon enum sabitleri tarafından override
 *      edilmek zorundadır. Open olanlar override edilmek zorunda değildir.
 *
 *      Enum sabitleri constructor alabilirler ama içlerine direkt olarak property tanımlanamaz. Ancak enum class' ı
 *      kendi constructor' ında bir property' e sahipse tüm enum sabitleri bu property' e kendi constructor' larında
 *      sahip olmak zorundalar. BU property' ler val, var veya boş (var, val olmadan) tanımlanabilirler.
 *
 *      Sabitler tek başlarına bir class mirası veya bir interface implement' i alamazlar.
 *      Sabitlerin önüne class yazılamaz.
 */
final enum class Directions private constructor(val trName: String) : IFoo {
    NORTH("KUZEY") {
        override fun yoo() {
            foo()   // enum class fonksiyonlarına doğrudan erişileblir.
            TODO("Not yet implemented")
        }

        override fun iBoo() {
            TODO("Not yet implemented")
        }

        override fun toString(): String {
            return "north toString"
        }
    },
    SOUTH("GÜNEY") {
        override fun yoo() {
            TODO("Not yet implemented")
        }

        override fun iBoo() {
            TODO("Not yet implemented")
        }
    },
    EAST("DOĞU") {
        override fun yoo() {
            TODO("Not yet implemented")
        }

        override fun iBoo() {
            TODO("Not yet implemented")
        }
    },
    WEST("BATI") {
        override fun yoo() {
            TODO("Not yet implemented")
        }

        override fun iBoo() {
            TODO("Not yet implemented")
        }
    };

    private constructor(type: Int, trName: String) : this(trName)

    fun foo() {

    }

    open fun boo() {}

    // Abstract function override edilmek zorundadır.
    // Abstract function' lar hem abstract sınıflar hemde enum sınıflar içerisinde tanımlanabilirler.
    abstract fun yoo()


    // iFoo Team içerisinde override edildiği için enum sabitlerinde override edilme zorunluluğu kalktı. Ancak iBoo override
    // edilmediği için bütün enum sabitleri mecburi olarak override etmek zorundalar.
    override fun iFoo() {
        TODO("Not yet implemented")
    }
}

interface IFoo {
    fun iFoo()
    fun iBoo()
}

abstract class ACFoo() {
    abstract fun aFoo()
}

fun main() {
    Directions.NORTH    // enum sabitleri kullanımı
    Directions.NORTH.ordinal    // enum sabit index' i. 0 ile başlar
    Directions.NORTH.name   // enum sabitinin ismi, toString()' ten bağımsız
    Directions.NORTH.trName // enum sabitinin constructor' ında aldığı property
    Directions.NORTH.boo()  // call function

    Directions.values() // enum sabitlerinin listesini verir
    Directions.entries  // values ile aynı
    Directions.valueOf("NORTH") // enum sabitini verir


    println(Directions.NORTH)   // north toString
}
