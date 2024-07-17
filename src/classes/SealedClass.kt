package classes

/**
 *      gruplanabilen class' lar için kullanılır.
 *
 *      visibility modifier kullanılabilir.
 *      primary ve secondary constructor tanımlanabilir.
 *
 *      bir class' tan miras alabilirler. enum class' lar başka bir sınıftan miras alamazlar.
 *      miras alabilir veya miras verilebilirler. arka planda abstract olarak tanımlanmışlardır, open yapılamazlar.
 *
 *      constructor' ı default olarak protected' dır, bu yüzden nesnesi üretilemez. private olarakta tanımlanabilir.
 *      eğer constructor private olarak tanımlanırsa, sealed class içerisindeki subclass' lar harici herhangi bir class
 *      bu sealed class' tan miras alamazlar.
 *
 *      içerisine abstract function / property yazılabilir. Tanımlanan abstract member' lar alt class' larda override
 *      edilmek zorundadırlar.
 *
 *      interface' leri inherit edebilirler. Sealed class interface fonksiyonlarını override ederse, içeride kalan class
 *      lar nu fonksiyonları override etmek zorunda değillerdir (istenilirse edilebilir).
 *
 *      sealed class içerisinde tanımlanan class' lar, sealed class' ı miras almak zorunda değillerdir.
 *
 *      subclass' lar constructor' ına değer alabilirler. enum class' ın enum sabitlerinde böyle bir kullanım yapılamıyor.
 *      subclass' ların nesneleri oluşturulabilir, enum sabitlerinin nesneleri oluşturulamıyor.
 *      subclass' lar static değillerdir, nested class' lardır (abstract, open vb. yapılabilirler). Bu yüzden
 *      nesnelerinin oluşturulması gerekmektedir.
 *
 *      subclass' lar interface implement edebilirler.
 *
 *      sealed class' lar aynı module veya package içerisinde geçerlidirler, farklı module' ler tarafından görünmezler.
 *
 */
sealed class Errors protected constructor(val errorCode: Int) : A(), B {
    final class InternetError(val connectionType: String = "Wi-Fi", errorCode: Int) : Errors(errorCode) {
        override fun boo() {
            TODO("Not yet implemented")
        }

        override fun poo() {
            TODO("Not yet implemented")
        }

        override fun soo() {
            super.soo()
        }
    }

    class ServerError : Errors(1), F {
        override fun boo() {
            TODO("Not yet implemented")
        }

        override fun poo() {
            TODO("Not yet implemented")
        }

        override fun interfaceFun() {
            TODO("Not yet implemented")
        }
    }

    class OtherError(errorCode: Int) : Errors(errorCode) {
        override fun boo() {
            TODO("Not yet implemented")
        }

        override fun poo() {
            TODO("Not yet implemented")
        }
    }

    class UnknownError(errorCode: Int) {

    }

    override fun foo() {
        TODO("Not yet implemented")
    }

    fun qoo() {}
    abstract fun poo()
    open fun soo() {}

    constructor(errorCode: Int, errorType: String) : this(errorCode)
}

open class A {}

interface B {
    fun foo()
    fun boo()
}

class C : Errors(10) {
    override fun poo() {
        TODO("Not yet implemented")
    }

    override fun boo() {
        TODO("Not yet implemented")
    }
}

sealed class D private constructor(val value: Int) {
    class Sub : D(0)
}

//  constructor' ını private yaptığımız için sadece içerisinde tanımlanan subclass' lar tarafından miras alınabiliyor.
//  class E : D(0)

interface F {
    fun interfaceFun()
}
