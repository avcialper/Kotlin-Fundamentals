// scope functions table https://kotlinlang.org/docs/scope-functions.html#function-selection
fun main() {

    val name: String? = "kotlin"

    /**
     *  generic tipli bir extension function' dır, aynı zamanda içerisine bir fonksiyon parametresi aldığı için bir
     *  higher order function' dur. parametre olarak alınan fonksiyonun parametresi ve dönüş değeri' de generic tiplidir.
     *
     *  T = Context, R = Son satır (return type)
     *
     *  it (lambda param) ile dönen değer let' in solundaki değerin tipindedir. it yerine farklı bir isim verilebilir.
     *  bloğun son satırındaki değer generic bir return' dür. Yani bloğun son satırına yazılan değer bir değişkene
     *  atanabilir.
     */
    val letMessage = name?.let {
        val message = "hello $it"
        println(message)
        message
    }
    println("scope out $letMessage")

    /**
     *  let gibi generic tipli hem higher order hemde extension function. Farklı olarak higher order' ın aldığı fonksiyon' da
     *  bir extension function. bu yüzden scope başlangıcına it gibi bir ifade tanımlayamayız. extension function olduğu
     *  için direkt olarak this kullanılır. this' de scope function' ın kullanıldığı değişkeni ifade eder.
     *  burada name değişkenine karşılık geliyor.
     *
     *  T = Context, R = Son satır (return type)
     */
    name?.run {
        val message = "hello $this"
        println(message)
        message
    }

    /**
     *  herhangi bir değişken ile kullanılmaz.
     *  generic bir higher order function, parametre olarak alınan fonksiyonun geri dönüş değeri generic tipli.
     *  son satır geri döndürülür.
     */
    run {
        println("run scope function")
        "run"
    }

    /**
     *  generic tipli bir higher order function' dır.
     *  parametre olarak generic bir değişken ve bu değişkene extension function olarak yazılmış bir function almaktadır.
     *  generic return tiplidir, son satır return edilir.
     *
     *  extension function olduğu için lambda param kullanamayız, this kullanabiliriz. this parametre olarak verilen
     *  değeri ifade eder.
     *
     *  burada this, name' e karşılık gelir.
     */
    with(name) {
        val message = "hello $this"
        println(message)
        message
    }

    /**
     *  generic bir higher order ve extension function. parametre olarak alınan fonksiyon da bir extension function.
     *  bu yüzden lambda param kullanamayız, this kullanabiliriz. parametre olarak alınan fonksiyonun geri dönüş tipi
     *  Unit.
     *  Bir değişkene eşitlik olarak verilirse kendisini verir.
     */
    val res = name?.apply {
        println("hello $this")
    }
    println(res)    // kotlin

    /**
     *  generic bir higher order ve extension function. parametre olarak alınan fonksiyonun parametresi generic tip ile
     *  aynı, return tipi Unit. extension olmadığı için lambda param kullanılabilir. lambda paramın tipi generic' in
     *  tipi ile aynıdır.
     *  Bir değişkene eşitlik olarak verilirse kendisini verir.
     */
    name?.also {
        println("hello $it")
    }
}