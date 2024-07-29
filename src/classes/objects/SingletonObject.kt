package classes.objects

/**
 *      Java dosyasına bak, birçok açıklama orada.
 *
 *      Elimizde bir sınıf var ve bu sınıfın bir nesnesini kullanmamız gerekiyor. Ama bu nesnenin memory' de sadece
 *      bir tane olmasını istiyoruz. Sınıfın nesnesinden bir adet olması, o sınıf üzerinde yapılan işlemlerin farklı
 *      sınıfları da doğrudan etkilemesini sağlar. Bu sayede tek bir yerde yapılan değişiklik uygulama genelinde sınıfın
 *      nesnesinin kullanıldığı yerleri de etkilemiş olur. Veya oluşturulan nesnenin maliyeti fazla ise ve sürekli oluştur
 *      sil yapmak istemiyorsak, bu nesneyi yalnızca bir kere oluşturup üretim maliyetini azaltabiliriz.
 *      Yapı singleton formatında oluşturulduğunda, veri hafızda statik olarak saklanır. Bu durumda da Garbage Collector
 *      bu nesne üzerinde bir etki sağlamıyor. Hafızadaki kullanım ömrünü tamamen biz yönetiyoruz.
 *
 *      Object bir singleton class olduğu için class inherit ve interface implement edilebilir.
 */

// Object declarations
// singleton pattern oluşturuluyor. show kotlin bytecode
object Retrofit {
    var baseURL = "https://www.google.com"
}

interface TextWatcher {
    fun afterTextChanged(s: String?)
    fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
    fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
}

abstract class ObjectExpressionClass() {
    abstract fun awesomeFun()
}

class EditText {
    fun addTextChangedListener(textWatcher: TextWatcher?) {
    }
}

fun main() {
    val baseUrl = Retrofit.baseURL

    val editText = EditText()

    // Object expression
    // isimsiz bir nesne tanımlamak olarak düşünülebilir.
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: String?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    // isimsiz bir class' ın nesnesi olarak düşünülebilir. Interface içinde benzer.
    val objectExpressionClass = object : ObjectExpressionClass() {
        override fun awesomeFun() {
        }
    }

    val asd = object : ObjectExpressionClass(), TextWatcher {

        override fun afterTextChanged(s: String?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun awesomeFun() {
        }
    }

    editText.addTextChangedListener(textWatcher)
}