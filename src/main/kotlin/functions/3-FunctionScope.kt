package functions

fun main() {

    /**
     *      Bir fonksiyon herhangi bir sınıfın içeriisnde değil de bir dosyanın içerisinde boşlukta tanımlanıyorsa,
     *      Top Level Function adını alır.
     *
     *      Top Level Function 'lar statiklerdir.
     *
     *      Bir fonksiyonu oluluştururken top level tanımlama yapılmıyor, sadece bir sınıfa ait fonksiyonlar yazılabiliyorsa
     *      bunlara FUNCTION değil, METHOD denir. Bir fonksiyona fonksiyon  diyebilmemiz için Top Level tanımlanmalıdır.
     */

    calculateAtomPhysics()

}

/**
 *      Fonksiyon içerisinde fonksiyon tanımı yapılabilir. Bu fonksiyona Local Functions denilir.
 *      Sebebi ise yazdığınız fonksiyonun kendi sınıfınızdan dahi çağırılmasını istemeyebilirsiniz.
 *      Bu fonksiyonun herhangi bir başka fonksiyon ya da sınıf için değiştirilmesini istemeyebilirsiniz.
 *      Reflection ile fonksiyonlarınız erişilirken gizli kalsın isteyebilirsiniz.
 *      Bu gibi durumlarda bu çok önemli fonksiyonunuzu başka bir fonksiyon içerisine yazabilirsiniz.
 */

fun calculateAtomPhysics() {
    val userName = "Cod"
    println("Initialize process...")

    //  getValuesFromUserAndPrint()     // method henüz tanımlanmadığı için kullanılamaz.
    fun getValuesFromUserAndPrint() {   // Local Function
        userName.length
        val numberOne = readLine()!!.toInt()
        val numberTwo = readLine()!!.toInt()
        val result = numberOne + numberTwo
        println("result: $result")
    }

    getValuesFromUserAndPrint()
    println("Process has been done...")
}

/**
 *      Bir sınıfın içeirisindeki fonksiyonlara üye fonksiyonlar denir.
 */
class Car() {
    fun drive() {}      // Member Function
}

/**
 *      Bir fonksiyon Generic type alıyorsa, Generic Function olarak adlandırlır.
 */
fun <T> setColor(colorCodeID: T) {

}