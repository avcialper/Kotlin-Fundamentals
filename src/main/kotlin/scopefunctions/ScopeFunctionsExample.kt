package scopefunctions

data class User(var name: String, var age: Int)

class Person {
    var name: String = ""
    var age: Int = 0

    fun sayHello() {
        println("Hello")
    }

    fun foo(user: User?) {
        // run bloğu hem user null olduğunda hemde let' in döndürdüğü değer null olduğunda çalışır.
        val resOne = user?.let {
            null
        } ?: run {
            "run"
        }

        // burada ise user değeri null ise run bloğu çalışır, kullanıma göre hangisinin tercih edileceği önemli.
        val resTwo = user?.also {

        } ?: run {
            "run"
        }
    }
}

fun main() {
    val user = User("John", 18)

    /**
     *  parametre olarak alınan fonksiyon extension olduğu için name ve age değerine doğrudan erişebiliyoruz.
     *  bu kullanım ile nesne oluşturulduğu sırada içerisindeki değişkenler ve fonksiyonlar üzerinden işlemler
     *  yapabiliriz.
     */
    val person = Person().apply {
        name = "John"
        age = 19
        sayHello()
    }

    /**
     *  paramete olarak alınan fonksiyon extension olmadığı için lambda param kullanmamız gerekir.
     *  nesne oluşturulduğu sırada içerisindeki değişkenler ve fonksiyonlar üzerinden işlemler yapabiliriz.
     */
    val person2 = Person().also {
        it.name = "Jack"
        it.age = 19
        it.sayHello()
    }

    /**
     *  üstteki iki kullanım yerine let, run veya with kullanmış olsaydık son satırda oluşturulan nesneyi geri dönmek
     *  zorunda kalacaktık ve ekstra bir satır daha kod eklememiz gerekecekti. also ve apply direkt olarak içeriği
     *  geri döndürdüğü için son satıra return edilecek değeri yazmamıza gerek kalmayacaktır.
     */

}