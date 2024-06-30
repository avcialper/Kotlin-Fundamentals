package functions

fun main() {

    /**
     *      Fonksiyonlar Kotlin'de "First Class Citizen"dır. Yani;
     *          - değişkenlere değer olarak atanabilir
     *          - başka fonksiyonlara parametre olarak verilebilir
     *          - bir fonksiyonun geri dönüş değeri olablilir
     *      demektir.
     *
     *      Higher Order Function' lar basitce parametre olarak fonksiyon alabilen fonksiyonlardır.. Parametre olarak
     *      verilmekten kasıt, fonksiyonun çağırımının parametre kısmında yapılması değil, fonksiyonun gövdesinin (body)
     *      yani süslü parantezler arasında kalan görev alanının başka bir fonksiyona parametre olarak verilmesidir.
     *      Dışarıda tanımlanan herhangi bir fonksiyonu direkt olarak kullanamayız. Direkt fonksiyonu çağırırsak, fonksiyon
     *      bize sadece bir değer döndürmekle görevli olur. Bize fonksiyon body'si lazım. Bunun kullanımı ileride anlatılacak.
     *
     *      Yapısal olarak;
     *
     *      fun higherOrderFunction(normalFunction: (message: String) -> Unit){
     *          normalFunction("kotlin")
     *      }
     *
     *      Çağırılırken;
     *
     *      fun main(){
     *
     *          higherOrderFunction({message ->
     *              println("Message: $message")
     *          })
     *
     *          higherOrderFunction(){ message ->
     *              println("Message: $message")
     *          }
     *
     *      }
     */

    //  Higher Order Function' lar için fonksiyon tanımlamanın 3 yolu vardır.

    /*
        Bir değişkene atayarak fonksiyon tanımlayabiliriz.
        Bu durumda süslü parantezler yanına higher order function' ın aldığı parametreler lambda okundan önce aralarına
        koyularak yazılır. Higher Order Function tek parametre alıyorsa, bu parametreleri yazmak zorunda değilsiniz.
        Bu durumda function size "it" kelimesi ile function' ın parametresi tipinde bir değişken verir.
     */
    val lambdaExpression = { surname: String -> "surname $surname" }
    val lambdaExpression2: (String) -> String = { surname: String -> "surname $surname" }

    /*
        İsmi olmayan "anonymous function" tanımlamaları da Higher Order Function lara parametre olarak verilebilirler.
     */
    val anonymousFunction = fun(surname: String): String {
        return "surname $surname"
    }

    /*
        Anonymous Function' ın expression olarak tanımlayabliriz.
     */
    val expressionAnonymousFunction = fun(surname: String): String = "surname $surname"

    /**
     *      Bir fonksiyon, Higher Order Function' a parametre olarak verilecek fonksiyon ile;
     *          - aynı parametre sayısına sahip
     *          - parametre tipleri aynı
     *          - geri dönüş tipi aynı
     *      ise bu fonksion da Higher Order Function'a parametre olarak verilebilir.
     *      Bunun için fonksiyon parametre olarak tanımlanırken başına :: konulur. Bu sayede fonkisyon kullanıldığı yerde
     *      geriye değer döndürmek yerine body' sini kullanmamızı sağlar.
     */

    val news = News()
    news.read(::println)
    news.read({ title: String -> println(title) })
    news.read { title: String ->
        println(title)
    }
    news.read {     //  it gizli ve String tipinde.
        println(it)
    }

    val titleFun = fun(title: String) {
        println(title)
    }
    news.read(titleFun)

    printUserInfo(getName(), lambdaExpression, getAge())
    printUserInfo(getName(), anonymousFunction, getAge())
    printUserInfo(getName(), fun(surname: String): String {
        return "surname $surname"
    }, getAge())

    //  Süslü parantezler (body) direkt olarak Higher Order Function ın parametre olarak beklendiği alana da yazılabilir
    printUserInfo(getName(), {
        "surname $it"
    }, getAge())

    getItemClickListener({ buttonName -> println("$buttonName tıklandı...") })

    /**
     *      Eğer bir fonksiyon parametreleri içerisinde bir Function son parametre olarak tanımlandıysa, bu durumda
     *      -isteniliyorsa- bu function, fonksiyon parametrelerinin dışına da yazılabilir. Daha temiz bir kullanımdır.
     */
    val newsType = NewsType()
    news.getNewsFromServer("FoxTV", newsType, {
        println(this.toString())
    })
    // this için fonksiyona bir parametre yazmaya gerek yok.
    news.getNewsFromServer("FoxTV", newsType) { typeId ->
        println("channel type : $this, channel type id : $typeId")
    }

    /**
     *      Fonksiyon birden fazla parametre içeriyorsa, aralarına virgül koyarak lambda işareti ile tanımlamak zordur.
     *      Tek parametreye sahipse bu durumda parametre ismi ve lambda işareti koyulmayablir. Bu durumda ilgili parametre "it"
     *      kelimesi ile çağrılabilecektir.
     *      Eğer bir fonksiyon, parametre olarak sadece Higher Order Function alıyorsa bu durumda fonksiyonun parantezlerini
     *      hiç koymayabiliriz.
     */
    news.filter { filterType, getFilterName ->
        println("asd")
    }
}

fun getName(): String {
    return "kotlin"
}

fun getAge(): Int {
    return 13
}

/**
 *      İkinci parametre fonksiyon olarak tanımlanmıştır.
 *      Parametre olarak alınan fonksiyonlar default değer alabilirler. Bunun için basitce süslü parantezler açmak yeterlidir.
 *      Dikkat edilmesi gereken konu bu süslü parantezler içine, Higher Order Function parametre bekleniyorsa, bunlar verilmelidir.
 */
fun printUserInfo(name: String, getSurname: (surname: String) -> String = { surname -> "" }, age: Int) {
    println("name: $name, age: $age")
    println(getSurname("asd"))
}

/**
 *      Higher Order Function'a parametre tanımlarken sadece değişken tipini tanımlayarak da (değişken adı olmadan)
 *      kullanabiliriz.
 */
fun getItemClickListener(onClick: (String) -> Unit) {
    println("Tıklama işlemi başlatılıyor...")

    /**
     *  Bir higher order function, parametre olarak yazıldıktan sonra, bu parametrenin normal fonksyion içerisinde
     *  çağırılması gerekmektedir. Aksi halde bu higher order function tanımlamak mantıksız olur. Normal fonksiyonun
     *  çağırıldığı alandaki higher order function'ın body kısmı hiçbir zaman çağırılmaz demek olur.
     */
    onClick("Login")
    println("Tıklama işlemi bitti.")
}

class News() {
    fun getNewsType(newsType: NewsType): String {
        return when (newsType.toString()) {
            NewsType.breakingNews -> "Breaking"
            NewsType.urgent -> "Urgent"
            NewsType.local -> "Local"
            NewsType.global -> "Global"
            else -> "Normal"
        }
    }
}

class NewsType() {
    companion object {
        val breakingNews = "Breaking"
        val urgent = "Urgnet"
        val local = "Local"
        val global = "Global"
        val normal = "Normal"
    }
}

/**
 *      Bir Higher Order Function'ina parametre olarak verirlen className.() şeklinde tanımlama yapılabiliyor.
 *      Bu sayede ilgili class da parametre parantezi içerisinde yazılabiliyor.
 */
fun News.getNewsFromServer(channelType: String, newsType: NewsType, getNews: NewsType.(Int) -> Unit) {
    when (channelType) {
        "KanalD" -> getNews(newsType, 1)
        "ShowTv" -> getNews(newsType, 2)
        "Tv8" -> getNews(newsType, 3)
    }
}

/**
 *      Bir Higher Order Function 'ın parametresi de yine Higher Order Function olabilir.
 */
infix fun News.filter(getFilter: (filterType: String, getFilterName: () -> String) -> Unit) {
    getFilter("filterName") {
        "String return label"
    }
}

fun News.read(readTitle: (String) -> Unit) {
    readTitle("awesome title")
}