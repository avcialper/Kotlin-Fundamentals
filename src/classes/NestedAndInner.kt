package classes

class Outer {

    val name: String = "John"
    private val surname: String = "Doe"

    fun printFullName() {
        println("$name $surname\n")
    }

    /**
     *      Bir class içerisinde class keyword' ü ile tanımlanan yeni class, Nested Class' dır.
     *      Nested Class' a erişmek için Outer class' ından bir nesne oluşturmamıza gerek yok.
     *      Nested Class' lar arka planda static olarak tanımlanmışlardır. Yani class property ve function' larına
     *      erişmek için dış class' ın nesnesin oluşturmamıza gerek yok. Dış class' ın nesnesini oluşturmadığımız için
     *      bu class' ın property ve function' larıne erişemeyiz.
     *      open ve abstract yapılabilirler.
     *      Miras alabilirler.
     *      Primary ve secondary constructor tanımlanabilir.
     *      Interface implement edebilir.
     */
    class NestedClass {

        fun nestedFun() {
            println("print nested fun")
        }

    }

    /**
     *      Bir class içerisinde inner keyword' ü ile tanımlanan class' lardır.
     *      Inner Class' a erişmek için Outer class' ından bir nesne oluşturmamıza gerekmektedir.
     *      Inner Class' lar arka planda statik olarak tanımlanmadıkları için bu class' a ait property ve function' lara
     *      erişmek için dış class' ın nesnesine ihtiyaç duyarız. Dış class' ın da bir nesnesi oluşturulduğu için bu
     *      class' a ait property ve function' lara inner class içerisinde erişebiliriz.
     *      open ve abstract yapılabilirler.
     *      Miras alabilirler.
     *      Primary ve secondary constructor tanımlanabilir.
     *      Interface implement edebilir.
     */
    inner class InnerClass {

        fun innerFun() {
            println("print inner fun, name $name")  // name outer class içerisinde geliyor.
            printFullName()     // outer class function
        }

    }
}

fun main() {
    Outer.NestedClass().nestedFun()     //  Outer' ın nesnesine ihtiyaç yok.
    Outer().InnerClass().innerFun()     //  Outer' ın nesnesine ihtiyaç var.
}