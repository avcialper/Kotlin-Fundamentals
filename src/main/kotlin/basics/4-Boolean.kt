package basics

fun main() {
    /**
     *      8 bit alan kaplar
     *
     *      true ya da false değer alır
     *      Nullable olabilir
     *      0 ve 1 boolean değer olarka kullanılamaz
     */

    val isStudent: Boolean = true
    val isTeacher: Boolean = false
    val isMale: Boolean? = null

    /**
     *      || or
     *      && and
     *      ! not
     *
     *      lazily -> mantık operatörlerinde kontrol zamanı kısaltması olarak düşünülebilir
     *      booleanOne && booleanTwo -> soldaki değer false ise direkt false döner
     *      booleanOne ||  -> soldaki değer true ise direkt true döner
     */

    val booleanValOne = false
    val booleanValTwo = true

    if (booleanValOne && booleanValTwo) {
    }
    if (booleanValOne and booleanValTwo) {      // infix function
    }
    if (booleanValOne.and(booleanValTwo)) {     // infix function
    }

    if (booleanValOne || booleanValTwo) {
    }
    if (booleanValOne or booleanValTwo) {
    }
    if (booleanValOne.or(booleanValTwo)) {
    }

    if (booleanValOne.not()) {
    }
    if (!booleanValOne) {
    }
}
