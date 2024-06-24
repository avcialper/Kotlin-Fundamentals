package basics

fun main() {
    /**
     *  Bir değişkene null değer ataması yapabilmek için tipinin sonuna ? konulur.
     *  Eğer bir değişkene tip verilmez ve direkt null değer ataması yapılırsa, IDE tip çıkarımı yaparken
     *  bu değişkenin değerini Nothing? olarak işaretler. Çünkü hangi tipe karşılık geldiğini bilemez.
     */

    val name: String? = null
    val age: Int? = null

    val number = null   // val number: Nothing? = null a karşılık gelir

    var result: Int? = 0
    result?.plus(123)   // Eğer null değilse işlemi gerçekleştirir
    result!!.plus(123)  // nullable değer kesinlikle null değil şeklinde ifade eder, hataya sebep olabilir

    /**
     *  Debug modda çalışırken !! kullanmak  Kotlin Null Pointer Exception almamızı sağlar. Bu sayede gözden kaçan
     *  nullable değerleri bulabiliriz. Ancak canlıya çıkacağımız zaman crush olmamak için ? kullanmamız daha doğru
     *  olacaktır
     */

    result!!.plus(500)
    result.plus(500)    // Üstte kesinlikle null değil dediğimiz için !! veya ? kullanmaya gerek yok
    /**
     *  Nullable bir değer !! ile kullanımışsa, kullanıldığı yerden sonra herhangi bir yerde tekrardan !! veya ?
     *  kullanmamıza gerek kalmaz. Bu özelliğe SMART CASE denir.
     */
}