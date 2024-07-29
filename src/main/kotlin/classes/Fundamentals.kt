package classes

//  Class isminin yanındaki () primary constructor' dır. Constructor' lar default argument alabilirler.
//  constructor keyword' ü kullanılmak zorunda değil. Eğer visibility modifier kullanmak istersek ya da
//  annotation vermek istersek constructor keyword' ünü kullanmamız gerekir.
class Turtle constructor(mName: String = "Tosbik") {

    val feetCount: Int = 4
    val feetColor: String = "Brown"
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1
    val tailColor: String = "Brown"
    val age: Int = 1
    val sex: String = "Female"
    var isMarried: Boolean = false
    var name: String = "turtle name"

    // Bu şekil property atamaları ve init bloğu işlemleri sırası yazım sırasına göredir.
    val lowerCaseName: String = mName.lowercase().also { println("property assignment") }

    /*
        Primary Constructor' ın body' si. Class' tan nesne oluşturulunca çalışan ilk blok.
        Eğer biz bir primary constructor yazmazsak arka planda otomatik olarak boş bir primary constructor oluşturulur.
        Bu init blokları da primary constructor' lara bağlı olduğu için biz constructor tanımamasak bile nesne ilk
        oluşturulduğunda bir kere çalışır.
     */
    init {
        println("primary constructor body")
        name = mName
    }

    var isMarriedToString = isMarried.toString().also { println("isMarried to string") }

    /*
        Secondary Constructor. Bu constructor' ı oluşturduğumu zaman this() içerisine primary constructor' ın aldığı
        değerleri vermemiz gerekir. Yani kendi parametrelerinin yanında primary constructor' ın parametrelerini de almak
        zorunda.
        Bu constructor çalıştığı zaman init bloğu da çalışır. Yani primary constructor da çalışır. Primary constructor,
        secondary constructor dan önce çalışır.
        Secondary constructor parametrelerine val/var yazılamaz.
     */
    constructor(mName: String, mIsMarried: Boolean) : this(mName) {
        isMarried = mIsMarried
        println("secondary constructor")
    }

    fun makeSound(): String {
        return "eheheheheh"
    }

    fun eatMeal() {
        println("turtle eat meal")
    }

    fun walk() {
        println("turtle is walking")
    }

    fun swim() {
        println("tutorial is swimming")
    }
}

/**
 *      Primary Constructor içerisine alınan parametrelere val veya var keyword' leri verilirse, bu değişkenler
 *      bu class' ın bir üye değişkeni gibi davranır. Bu keyword' ler verilmezse değişkenlere ya init bloğu içerisinde
 *      ya da class property' lerine değer ataması yaparken kullanabiliriz (name ve surname' i birşeltirip fullName
 *      şeklinde bir property tanımlamak gibi). Ama oluşturduğumu üye fonksiyonlarımız içerisinde bu constructor
 *      parametrelerine erişemeyiz.
 *
 *      Yani class içerisinde herhangi bir yerde bu değişkenleri kullanmak istersek val veya var keyword' ü ile
 *      tanımlama yapmamız gerekir.
 *
 *      Eğer val veya var yazılmazsa constructor' da tanımlanan değerler, bu class' tan oluşturulan nesnelerde de
 *      kullanılamaz.
 *      val user = User(name = "John", surname = "Doe")
 *      user.name   // Erişmek için name değerinin val veya var olması gerekir.
 *
 *      Aynı şekilde val ve var' ın özelliklerini taşırlar. Class içerisinde değer değiştirilmek istenmezse val,
 *      istenirse var şeklinde tanımlanabilir.
 */
class User(val name: String, var surname: String) {

    fun printUserInfo() {
        println("Name: $name, Surname: $surname")
    }

    fun changeSurname(mSurname: String) {
        surname = mSurname
    }

}

/**
 *  Primary constructor' ını private yaparsak aslında erişilemez bir sınıf oluşturmuz oluyoruz.
 *  NonCreatableClass' için secondary constructor tanımlamamış olsaydık bu class' tan bir nesne oluşturamazdık.
 *
 *  Bir class' ı abstract yapmadan nesnesinin oluşturulmasını engeller (secondary constructor' da tanımlanmamalı).
 */
class NonCreatableClass private constructor() {
    constructor(name: String) : this() {
        println("Name: $name")
    }
}

fun main() {
    val turtleOne: Turtle = Turtle()
    val turtleTwo: Turtle = Turtle("Donatello")
    val turtleTree: Turtle = Turtle("Donatello", true)
    turtleOne.walk()

    val nonCreatableClass = NonCreatableClass("john")
    /**
     *      Kotlinde class' lardaki constructor yapısı nasıldır?
     *          - Kotlinde iki farklı constructor vardır. Primary ve secondary.
     *              - Primary constructor: Class isminin yanına () açılarak tanımlanırlar.
     *              - Secondary constructor: constructor parametresi ile tanımlanır. Kendi parametreleri yanında
     *              primary constructor parametrelerini de almak zorundadır.
     *
     *      init bloğu nedir?
     *          - Nesne oluşturulduğu zaman çalışan ilk bloktur. Yani primary constructor' ın body' sidir.
     *
     *      Secondary Constructor çalıştığı zaman Primary Constructor da çalışır.
     *      Primary Constructor, Secondary Constructor' dan önce çalışır.
     *
     *      Eğer biz constructor ile bir Secondary Constructor tanımlamış olsak ve primary constructor tanımlamamış
     *      olcak bile otomatik olarak boş bir primary constructor oluşturulur. Bu sayede nesne oluşturma aşamasında
     *      secondary constructor ı kullanmadan nesne oluşturabiliriz.
     *
     *      class A(){
     *          var name: String = "name"
     *          constructor(mName: String): this(){
     *              name = mName
     *          }
     *      }
     *
     *      val aOne = A()
     *      val aTwo = A("name sample")
     *
     *      iki şekilde de nesne oluşturulabilir.
     */
}