package basics


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