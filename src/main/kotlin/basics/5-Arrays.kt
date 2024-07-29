package basics

fun main() {

    /**
     *      Aynı türden ya da belirtilen türün alt türlerinden, sabit sayıda veri tutan bir veri yapısıdır.
     *      En sık kullanılan versiyonu Object-Type Array'lerdir. Array sınıfı ile temsil edilirler.
     *
     *      Eğer primitive tipleri Object-Type Array olarak kullanırsanız Boxed kullanım yapmış olursunuz.
     *      Bu da performansa etki eder. Eğer sadece primitive'lerden oluşan array'ler oluşturacaksanız,
     *      bu durumda Primitive-Type Array'ler kullanın.
     *
     *      ByteArray(byte[]), ShortArray(short[]), IntArray(int[]), LongArray(long[]),
     *      DoubleArray(double[]), FloatArray(float[]),
     *      BooleanArray(boolean[]), CharArray(char[])
     *
     *      arrayOf(aynı tip değerler)
     *      arrayOf<Any>(farklı yip değerler)
     *      arrayOfNulls<Type>(size) şeklinde verilen değer kadar null değer içeren dizi tanımlanır
     *      emptyArray() boş array tanımlar
     */

    //                     index 0   1   2   3   4
    val studentNumbers = arrayOf(13, 25, 30, 49, 57)
    val studentName = arrayOf("Ahmet", "Ayşe", "Elif", "Veli")
    val firstCharOfNames = arrayOf('A', 'A', 'E', 'V')
    val mixedArray = arrayOf<Any>(13, "Kenan", 'K', false)  // <> arasına tip vermekte bir interface'dir

    val arrayOfNulls = arrayOfNulls<String>(5)
    println(arrayOfNulls.joinToString())    // Array'i string formatında yazmak istenirse joinToString kullanılır

    /**
     *      Empty Array'ler istenilen yere direkt olarak veri eklenemez. İçerisinde kaç eleman barındırdığı bilinmediği için.
     */

    val emptyArray = emptyArray<String>()
    var emptyArray2: Array<String> = emptyArray()
    // emptyArray[5] = "code"   // verilemez

    /**
     *      Array'ler sabit büyüklüktedirler. Array'lere ekleme ve çıkarma yapmak aynı String'lerde olduğu gibi
     *      memory'de yeni bir Array oluşturulmasına neden olur.
     */

    var citiesArray = arrayOf("İstanbul", "Hatay", "Kars")
    // Array'e veri eklenmek istenirse var olarak tanımlanmalıdır
    citiesArray += "Sivas"
    citiesArray += arrayOf("İzmir", "Konya")    // Başka bir array ekleme
    println(citiesArray.joinToString())

    /**
     *      Array<Type>(size{higher order function} şeklinde de tanımlanabilir.
     *      Bu durumda higher order functioniçerisinde son satıra denk gelen değerler diziyi oluşturur.
     *      Higher order function, içerisi dizinin boyutu kadar index'i (it) arttırarak çalışır.
     */

    val carNamesMini = Array<Double>(5) {
        // it index'i verir -> 0, 1, 2, 3, 4
        3.14 * it
    }
    println(carNamesMini.joinToString())

    /**
     *      ByteArray, ShortArray, IntArray, LongArray, DoubleArray, FloatArray gibi ya da bunların unsigned halleri
     *      primitive array tanımlamaları da yapılabilir.
     *
     *      .toTypedArray() fınksiyonu ile Objet-Type bir array Primitive-Type bir array'e dönüştürülür. Buradki typed
     *      değiştirlecek tip. toCharArray() gibi.
     *
     *      İlgili index değerine set(index, value) yada [index] = value ile atama yapılabilir.
     *      get(index) veya [index] şeklinde ulaşılabilir.
     */

    val firstCharOfCountries = CharArray(4)
    firstCharOfCountries[0] = 'T'
    firstCharOfCountries.set(1, 'I')
    firstCharOfCountries.set(2, 'E')

    println("First CharOf Countries: ${firstCharOfCountries[0]}")
    println("First CharOf Countries: ${firstCharOfCountries.get(1)}")

    // arrayOf ile tanımlanan array bir object array, bunu toCharArray() fonksiyonu ile primitive array yapabiliyoruz.
    // Bu kullanım bize performans açısından artı sağlamaktadır.
    val charTypedArray: CharArray = arrayOf('K', 'O', 'T', 'L', 'I').toCharArray()

    /**
     *      val ile tanımlanmış bir array'in herhahngi bir indexindeki değer değiştirilebilir.
     *      val indexdeki değerlerin değişimine karışmaz.
     *      Ancak ilgili diziyi başka bir dizi ile eşitlememize izin verilmez.
     *      Bunun için tanımlamayı var ile değiştirmemiz gerekir.
     */

    val awesomeArray = arrayOfNulls<String>(5)
    awesomeArray[0] = "kotlin"
    //awesomeArray = arrayOf("foo", "boo", "goo", "loo")    // Çalışmaz
    //awesomeArray += "java"    // Çalışmaz

    /**
     *      Array'in size'i dışına çıkıyorsanız (boyut dışına), IndexOutOfBound hatası alırsınız.
     */
    //awesomeArray[7] = "android"    // Hata verir

    // 2 boyutlu Array
    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
    println(twoDArray.contentDeepToString())
    // [[0, 0], [0, 0]]

    // 3 boyutlu Array
    val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 3 } } }
    println(threeDArray.contentDeepToString())
    /*
    [
        [
            [3, 3, 3], [3, 3, 3], [3, 3, 3]
        ],
        [
            [3, 3, 3], [3, 3, 3], [3, 3, 3]
        ],
        [
            [3, 3, 3], [3, 3, 3], [3, 3, 3]
        ]
    ]
     */

    // Array'ler her zaman değişebilirdir (mutable)
    val simpleArray = arrayOf(1, 2, 3)
    simpleArray[0] = 10
    twoDArray[0][0] = 2

    println(simpleArray.joinToString())
    println(twoDArray.contentDeepToString())    // Çok boyutlu Array' leri String halinde göstermek için kullanılır.

    // Aynı zamanda Array'ler üst class'ları yerine atanamazlar (invariant).
    // Örneğin Number bir array'i Int bir array'e eşitleyemeyiz.
    val arrayOfString: Array<String> = arrayOf("V1", "V2")
    //val arrayOfAny: Array<Any> = arrayOfString    // Hata
    val arrayOfAny2: Array<Any> = arrayOf("V1", "V2")

    val arrayOfInt: Array<Int> = arrayOf(1, 2, 3)
    //val arrayOfNumber: Array<Number> = arrayOfInt     // Hata

    /**
     *      vararg kelimsei ile istediğimiz sayıda parametreyi kabul edebiliriz.
     *      Eğer vararg'a denk gelecek şekilde bir array kullanmak istiyorsak "spread" "*" operatörü kullanırız.
     *      Spread operatorü verdiğiniz array'in elemanlarının her birini bir variable olacak şekilde bir parametre olarak passlar.
     */
    val lettersArray = arrayOf("c", "d")
    // Kendi yazdığımız fonksiyon
    printAllStrings("a", "b", *lettersArray)    // Buradaki * spread operatörüdür

    /**
     *      Array'leri karılaştırırken == operatörü kullanılamaz. == operatörü o array'lerin referans object'lerini
     *      karşılaştırır.
     *      contentEquals ya da contentDeepEquals kullanmanız lazım.
     */

    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(1, 2, 3)

    if (array1 == array2) {
        println("array1 == array2")
    } else {
        println("array != array2")
    }

    val copyOfArray1 = array1
    val copyOfArray1Two = array1

    // İkiside aynı adresi gösteriyor
    if (copyOfArray1 == copyOfArray1Two) {
        println("copyOfArray1 == copyOfArray1Two")
    } else {
        println("copyOfArray1 != copyOfArray1Two")
    }

    // Tek boyutlu bir array karşılaştırılmak istenirse
    println("contentEquals ${array1.contentEquals(array2)}")

    val array3 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
    val array4 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
    // Çok boyutlu array'lerde
    println("contentDeepEquals ${array3.contentDeepEquals(array4)}")

    /**
     *      .sum() -> toplama işlemi; sadece number typed arraylar ile çalışır.
     *      .shuffle() ->  random karıştırma; elemanları random şekilde yer değiştirir
     */

    val sumOfArray = array1.sum()
    println(sumOfArray)

    val randomArray = arrayOf(1, 2, 3, 4, 5, 6, 7)
    randomArray.shuffle()
    println(randomArray.joinToString())

    /**
     *      Array'ler List'e ve Set'e dönüştürülebilir.
     */

    val sampleArray = arrayOf("a", "b", "c", "c")
    println(sampleArray.toSet())    // Set te tekrar eden elemanlar kaldırılır
    println(sampleArray.toList())

    /**
     *      Bir array Map'e de dönüştürülebilir. Ancak bunun için array'in özel olarak Pair<K,V> formunda olması lazım.
     */
    // Pair yapısı
    val cities = arrayOf(34 to "Istanbul", 35 to "Izmir", 7 to "Antalya")
    println(cities.toMap())
}

fun printAllStrings(vararg strings: String) {
    for (s in strings) {
        print(s)
    }
    println()
}