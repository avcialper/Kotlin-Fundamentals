package classes.generics

/**
 *      Kotlin' de class' lar type parameters' lara sahip olabilirler. Yani class' lar belirli bir tür üzerinde çalışmak
 *      yerine türden bağımsız olarak çalışabilir. (generic classes)
 *
 *      Kotlin wildcard' ları desteklemiyor. Bunun yerine Declaration-site variance ve type projections kavramları
 *
 *      Neden generic types yerine any kullanamayız?
 *          - Any ile type safety sağlanamaz. Mesela içeride matemetiksel bir işlem yapılıyor ama string verdik, burada hata
 *          oluşur.
 */
class Box<T>(t: T) {    //  constructor' da parametre vermek için T constructor önüne konulur
    val value: T = t

    //  L ya parametre olarak verilmeli veya geri dönüş tipi olarak
    fun <L> foo(l: L) {}
}

fun main() {

    val box: Box<Int> = Box<Int>(1)

    /**
     *      kotlin' de de generic' ler invariant' dır.
     *      Yani bir generic' e Double tipini veriyorsak değer olarakta Double vermemeiz gerekir.
     *      Belirtilen tipin alt ve üst tipleri (subtype ve supertype) olamaz.
     */
    //  val box2: Box<Number> = Box<Int>(1)     //  hata

    val box3 = Box(2)   //  type inference
}

/**
 *      Declaration-site variance
 */

//  out, covariant kullanımı içindir. (Kendisi veya SubType' ları geçerli olur)
interface Source<out T> {
    fun nextT(): T
}

fun demo(strings: Source<String>) {
    val objects: Source<Any> = strings
}

//  in, contravariant kullanımı içindir. (Kendisi veya SuperType' ları geçerli olur)
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0)
    val y: Comparable<Double> = x
}

/**
 *      Type-projections in and out
 *
 *      out T kullanımı ile beraber kendisini ve supertype' larını alabileceğini biliyoruz.
 *      Böylece alt türerin kullanımı engelleniyor. Ama bazen bu kısıtlamayı da yapmak istemeyiz.
 *      Array' ler buna güzel bir örnek
 *
 *      class Array<T>(val size: Int): T {
 *          operator fun get(index: Int): T { }
 *          operator fun set(index: Int, value: T) { }
 *      }
 */

fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

fun copy2(from: Array<out Any>, to: Array<Any>) {
    for (i in from.indices)
        to[i] = from[i]
}

fun fill(dest: Array<in String>, value: String) {
    for (i in dest.indices)
        dest[i] = value
}

fun demo() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(2) { "" }
    /*
        Array<T> bu durum için  Array<Int> invariant durumda yani değişemez.
        Yani ne Array<Int> ne de Array<Any> birbirinin subtype' ı değildir. Niye değildir. Çünkü copy' de beklenmedik
        durumlar oluşabilir. Bu durumda String bir array' i Int bir Array' e kopyalamaya çalışabilirsiniz.
     */
    //  copy(ints, any)     //  yorum satırını kaldır hatayı gör.

    /*
        copy2' deki kullanıma kullanıma baktığımızda bunu artık yapabiliriz. Buna Type-Projection deniliyor.
        copy2' deki Array<out Any> ifadesi, Java' daki Array<? extends Object>' e karşılık geliyor.
     */
    copy2(ints, any)

    //  fill' deki Array<in String> ifadesi, Java' daki Array<? super String>' e karşılık geliyor.
    val string: Array<String> = arrayOf("a", "b", "c")
    fill(string, "d")
}

/**
 *      Star-projections
 *
 *      Bazen type argument hakkında hiçbir şey bilmeyiz. Yine de bunu güvenli bir şekilde kullanmamız gerekmektedir.
 *
 *      Foo<out T: TUpper> T bu durumda covariant oluyor ve kendisi ile subtype' larını alıyor
 *      Foo<*> Foo<out TUpper>' ın eş değeri oluyor. read için Foo<out TUpper>
 *
 *      Foo<in T> T bu durumda contravariant oluyor ve kendisi ile supertype' larını alıyor.
 *      Foo<*> ise Foo<in Nothing>' in eş değeri oluyor. write için Foo<in Nothing> oluyor
 *
 *      Foo<T: Upper> T bu durumda invariant oluyor, super' i TUpper için.
 *      Foo<*> ise read için Foo<out TUpper> write için Foo<in Nothing> oluyor.
 *
 *
 */

/*
        Function<*, String> ifadesi Function<in Nothing, String> olur.

        Bu ifade, Function' ın parametrelerinin türlerini belirtmediğimiz ancak dönüş değeri türünün String olduğu bir
        fonksiyonu temsil eder. Bu durumda, herhangi bir türden parametre kabul edebiliriz, ancak dönüş değeri her zaman
        String olmalıdır. Bu Kotlin' de Function<in Nothing, String> ile aynıdır. Nothing, diğer tüm türlerin alt türüdür,
        bu yüzden Function herhangi bir türden paramatre kabul edebilir.
 */

/*
        Function<Int, *> ifadesi Function<Int, out Any?>

        Bu ifade, Function' ın Int türünden bir parametre aldığı ancak dönüş değeri türünün belirli bir türle sınırlı
        olmadığı bir Function' ı temsil eder. Yani, herhangi bir dönüş değeri türüne sahip olabilirler. Bu durumda,
        dönüş değeri Any? olarak kabul edilir. Çünkü Any? türü herhangi bir türün üst türüdür ve nullable olabilir (?)
 */

/*
        Function<*, *> ifadesi Function<in Nothing, out Any?>

        Bu ifade, hem parametrelerin hem de dönüş değerinin türlerinin belirli bir türle sınırlı olmadığı bir Function' ı
        temsil eder. Yani, Function herhangi bir türden parametre kabul edebilir ve herhangi bir türde dönüş değeri
        verebilir. Bu durumda, yine Function<in Nothing, out Any?> ile aynıdır. Çünkü parametre türü Nothing (yani
        herhangi bir tür) ve dönüş değeri türü Any? (yani herhangi bir tür veya nullable bir değer).
 */

class Boxs<T>(val item: T)

fun printBox(box: Boxs<*>) {
    val item = box.item
    println(item)
}

fun demo2(){
    val stringBox = Boxs("kotlin")
    val intBox = Boxs(2017)

    printBox(stringBox)
    printBox(intBox)
}
