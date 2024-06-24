<h1>BASIC TYPES</h1>

Aynı işi yapan Java ve Kotlin kodlarının bytecode karşılıkları aynıdır. Yani class olarak tanımalanan Int, Boolean, Char
gibi tipler compile zamanında bytecode olarak Java'daki primitive tiplere karşılık gelen bytecode'lar ile aynı gelir.

`val` oluşturulduktan sonra tekrardan değer ataması yapılamayan veri türüdür. `val` **immutable** değilidr, **read only**
dir. **Immutable** oluşturulduktan sonra değiştirilemeyen nesne/değişkendir. **Read only** de ilk oluşturulduktan sonra
yeniden
atama yapılamaz. **Immutable** da ise nesnenin durumunu değiştirmenin bir yolu yoktur.

````kotlin
class Box {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 50
    var usedSpace: Int = 0

    val availableSpace: Int
        get() {
            return (width * height * length) - usedSpace
        }
}
````

Burada `availableSpace` olarak tanımlanan değer `val`, burada sınıfın değişkenlerine dışarıdan farklı değerler atarsak
`availableSpace` değeri farklı sonuçlar döner.
[medium.com](https://xabaras.medium.com/kotlin-val-is-read-only-not-immutable-585ce2e5359b)

`var` sonrasında değer ataması yapılabilen veri türüdür. İkisi arasında performans farkı yoktur. Ama `val` değişken
oluşturmak
daha maliyetlidir. Çünkü değerler if condition ile kontrol edilirler.

Kotlin’de `type inference` vardır, yani başlangıçta tür belirtilmese bile otomatik olarak tür çıkarımı yapılır.

Bir var değişkeni val olarak kullanmak istersek değişkenin setter'ını **private** olarak ayarlamamız yeterli olur.

```kotlin
class Person {

    val name: String = "alper"

    var surname: String = "avcı"
        private set

    // private değer sadece class dışını etkiler, class içerisinde herhangi bir etkisi bulunmaz
    fun changeSurname(surname: String) {
        this.surname = surname
    }
}

fun main() {

    val person = Person()

    // person.name = "ALPER"        // name değeri val olduğu için yeniden atama yapamayız
    // person.surname = "AVCI"      // surname' in set fonksiyonu private olduğu için dışarıdan değer ataması yapamıyoruz.

    println(person.surname)         // avcı
    person.changeSurname("AVCI")
    println(person.surname)         // AVCI

}
```

**Heap And Stack** <br>
Eğer değişkenimiz primitive type ise hem değişkenin kendisi için hemde bu değişkenin ifade ettiği değer için **stack'de
** (2 adet) yer ayrılır. <br>
val age: Int = 20 <br>
burada age için bir alan ve bu age'in değeri için (20) başka bir alan kullanılır. <br>
**Stack** alanı **heap** alanına göre daha hızlıdır. <br>
Eğer değişkenimiz bir primitive type değilse (nullable int, object ..) değişkenimiz yine **stack'de** tutulur ama bu
sefer içerisindeki değer
**heap'de** tutulur.

[1-Numbers](../src/basics/1-Numbers.kt) <br>
[2-TypeConversion](../src/basics/2-TypeConversion.kt) <br>
[3-Characters](../src/basics/3-Characters.kt) <br>
[4-Boolean](../src/basics/4-Boolean.kt) <br>
[5-Arrays](../src/basics/5-Arrays.kt) <br>
[6-String](../src/basics/6-String.kt) <br>
[6-Range](../src/basics/7-Range.kt) <br>
[8-Nullables](../src/basics/8-Nullables.kt)