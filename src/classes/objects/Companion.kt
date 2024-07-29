package classes.objects

class HomeFragment {
    var valueList = listOf<String>()

    /**
     *  Arkada companion object için yine bir singleton class oluşturuluyor. Ama oluşturulan companion object, object kullanımından
     *  farklı olarak static tanımlanıyor. Bu sayede bu companion object' e içerisinde bulunduğu class' ın nesnesi
     *  oluşturulmadan erişilebiliyor.
     *  Singleton class' larda class' ın nesnesi class içerisinde tanımlanıyordu. Companion object için tanımlanan class' ın
     *  nesnesi ise içerisinde tanımlandığı class' ta static olarak bulunuyor. (yani burada HomeFragment içerisinde)
     *  Companion object yine bir singleton class' tır ancak ömrü üst class' ın ömrü kadardır (nesnesi class' ın içerisinde
     *  olduğu için). Garbage collector yine bu companion object' e dokunmaz.
     *  İçerisinde tanımlanan değerler static değillerdir, yani companion object' in nesnesine ihtiyaç duyalar. Static
     *  olmamalarına rağmen üstte bahsettiğimiz companion object' in nesnesinin class içerisinde static olarak oluşturulması
     *  fonksiyon ve property' kerin kullanımını sağlıyor.
     *  Bir class gibi davrandıkları için class inherit ve interface implement edilebilir.
     */
    companion object {
        fun newInstance(list: List<String>): HomeFragment {
            val fragment = HomeFragment()
            fragment.valueList = list
            return fragment
        }
    }
}

object ASD

fun main() {
    val homeFragment = HomeFragment.newInstance(listOf("A", "B", "C"))
    // companion object' e isim vererekte erişebiliriz.
    val homeFragment2 = HomeFragment.Companion.newInstance(listOf("A", "B", "C"))
}