package classes

class PublicClass {
}

private class PrivateClass {

}

// Class module içerisinde public, module dışında private olur.
internal class InternalClass {

}

/*
// function ve constructor' larda yazılabilir.
protected class ProtectedClass {

}
*/

class Visibility() {
    var numberOne = 5           //  get ve set methodları var. Eğer val olsaydı sadece get methodu olacaktı.
    private val numberTwo = 10  //  ne get nede set methodu var.

    var stringOne: String = "kotlin"
        set(value) {
            field = value
        }
        get() = field

    fun printNumber() {
        println(numberTwo)      // get fonksiyonu yok ama arka planda direkt filed' den erişiliyor. this.numberOne
    }
}

fun main() {

    /**
     *      Kotlin' de bir variable, class veya function' a bir visibility modifiers verilmezse default olarak
     *      public olarak tanımlanırlar.
     *
     *      Kotlin' de bir değişken oluştururken aslında bir değişken oluşturmuyoruz. Arka planda bu değişkenlerin
     *      private halleri tanımlanıyor ve public olarak getter setter methodları oluşturuluyor.
     *      (double shift - show kotlin bytecode)
     *
     *      Eğer bir bir değişkene visibility modifier vermezsek default olarak public olur demiştik. Yani istenildiği
     *      gibi get set edilebilir (arka planda hala private tanımlı). Ama eğer biz bu değişkeni private olarak
     *      tanımlarsak, arka planda bu değişken hala private olarak kalır ama getter ve setter fonksiyonları oluşturulmaz.
     *      Visibility class'ına bak (main'in üstünde).
     *
     *      Kotlin' de değişkenlere aslında variable denilmemeli, property denilmelidir. Property fonksiyon anlamına gelir.
     *      Çünkü arka plan karşılığına baktığımız zaman bu değişken için hem bir değişken hemde bu değişken için get ve
     *      set methodları oluşturulur.
     *
     *      Kotlin' de encapsulation yapılmıyormuş gibi gözüksede aslında arka planda sürekli olarak bir encapsulation
     *      yapılıyor ve biz buna müdahale edemiyoruz. Arka plan da hep private' lar.
     *
     *      Bir değişken, class içerisinde oluşturulursa propertydir. Ama bir değişkeni bir fonksiyon içerisinde
     *      oluşturusak backing-filed olarak oluşturulur. Yani tam anlamıyla bir variable (filed). Bu da demek oluyor ki
     *      fonksiyon içerisinde tanımlanan değişkenlerin get ve set fonksiyonları oluşturulmuyor.
     */

}