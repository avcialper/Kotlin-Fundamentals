package classes

/**
 *      Interface' ler constructor' a sahip olamazlar. Bu yüzden nesnesi oluşturulamaz.
 *      Interface içerisinde fonksiyon barındıran yapılardır.
 *      İçerisinde STATE tutamazlar!!!! Değişken tanımlanabilir ama bir değer ataması yapılamaz.
 *      Property ve function' lar default olarak abstract keyword' ü kullanmaktadırlar. Public olarak tanımlanırlar ve
 *      farklı bir erişim belirleyici tanımlanamaz.
 *      Aynı zamanda open keyword' ü de verilebilir. Ama open olması bir anlam ifade etmez, her şekilde override edilmesi
 *      zorunludur.
 */
interface TextWatcher {

    /**
     *  Bu değişken arka planda bir backing-filed' a sahip değil, yani bir state tutumuyor.
     *  Bu yüzden = ile bir değer ataması yapamayız.
     */
    val prop: Int   // val veya var olabilir, var olursa alta get fonksiyonu gibi set fonksiyonu yazamayız.
        get() = 99  // Burada da funWithBody deki durum gerçekleşiyor.

    abstract fun beforeTextChanged(text: String)
    fun onTextChanged(text: String)
    fun afterTextChanged(text: String)

    /**
     *      Kotlin' de interface fonksiyonlarına body tanımalanabiliyor. Body ile beraber tanımalanan fonksiyonlar open
     *      function olarak tanımlanıyorlar. Bu da bu fonksiyonların override edilme zorunluluklarını ortadan kaldırıyor.
     *      Arka planda ise bu body' si olan fonksiyonlar için static bir class oluşturuluyor. Static class' ların
     *      içeriğine nesnesi oluşturulmadan erişilebilir. Aynı şekilde bu class içersine tanımlanan bu fonksiyonun
     *      static bir fonksiyonu da tanımlanıyor.
     *      Yani arka planda hem body' si olmayan bir fonksiyon, hemde body' si olan static fonksiyonu tutan static bir
     *      class tanımlanıyor.
     */
    open fun funWithBody() {
    }
}

class DelegatingTextWatcher : TextWatcher {
    override val prop: Int
        get() = TODO("Not yet implemented")

    override fun beforeTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun funWithBody() {
        println("funWithBody")
    }
}

/**
 *      Interface, başka bir interface' implement edebilir. Bu durumda zorunlu override yoktur.
 *      Bu interface içerisinde farklı property ve function' lar ekleyip diğer interface ile birleştirme yapabiliriz.
 *      Eğer implement' e aldığı interface' in property veya function' ını override edip bunu kendisinin implement
 *      olduğu bir class' ta kullanım zorunluluğu ortadan kaldırılabilir.
 *      Aynı abstract class' lardaki gibi.
 *
 *      Abstract class' larda ikinci bir abtract class içerisinde zorunlu olmamasına rağmen bir property veya function' ı
 *      override edebiliyorduk. Override ettiğimiz property veya function' ın önüne final keyword' ünü koyduğumuz zaman
 *      artık bu class' tan miras alan hiçbir class bu property/function 'ı override edemez hale geliyordu. Ama interface
 *      için böyle bir şey yapamıyoruz. Interface içerisinde final keyword' ü kullanımı yasaktır.
 */
interface ChildInterface : TextWatcher {
    fun foo(): String

    // override edildiği için bir class' a override zorunluluğu kaldırıldı.
    override fun beforeTextChanged(text: String) {}
}

/**
 *      Abstract bir class' a interface implement edilirse yine interface implement etme gibi davranır. Yani override
 *      etme zorunluluğu bulunmaz.
 *      Ama burada söyle farklı bir durum var; eğer biz bir değişkeni/fonksiyonu override eder ve final keyword' ü ile
 *      tanımlarsak bu class' ı miras alan diğer class' lar override edilen bu değişkeni/fonksiyonu override edemez.
 *      Aynı bir abstract class' ı miras alan başka bir abstract class' taki kullanım gibi.
 */
abstract class Coo : TextWatcher {
    final override fun onTextChanged(text: String) {
        TODO("Not yet implemented")
    }
}

class InterfaceClass() : ChildInterface {
    override fun foo(): String {
        TODO("Not yet implemented")
    }

    override val prop: Int
        get() = super.prop

    override fun onTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun funWithBody() {
        super.funWithBody()
    }
}

class ChildOfCoo() : Coo() {
    override val prop: Int
        get() = super.prop

    override fun beforeTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(text: String) {
        TODO("Not yet implemented")
    }

    override fun funWithBody() {
        super.funWithBody()
    }
}

/**
 *      Bir değişken üzerinden bir interface' in fonksiyonlarını kullanmak istersek object expression kullanabiliriz.
 *      Object expression, anonymous class oluşturulmasını sağlar. Oluşturulan anonymous class' a interface' i implement
 *      edersek interface içerisindeki değişken ve fonksiyonları da override etme zorunluluğumuz geçerli olur. Bu
 *      sayede sanki interface' i bir class' a implement edip o class' tan bir nesne oluşturulmuş gibi oluyor.
 */
fun main() {
    val textWatcher = object : TextWatcher {
        override val prop: Int = 101

        override fun beforeTextChanged(text: String) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(text: String) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(text: String) {
            TODO("Not yet implemented")
        }
    }
}