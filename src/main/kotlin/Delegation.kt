import kotlin.reflect.KProperty

interface Printer {
    fun printDocument()
}

interface Scanner {
    fun scan()
}

class InkPrinter : Printer {
    override fun printDocument() {
        println("Ink Printer")
    }
}

class LaserPrinter : Printer {
    override fun printDocument() {
        println("Laser Printer")
    }
}

class MixedPrinter : Printer {
    override fun printDocument() {
        println("Mixed Printer")
    }
}

class FancyScanner() : Scanner {
    override fun scan() {
        println("Fancy Scanner")
    }
}

/**
 *  Printer interface' ini implement eden herhangi bir class' ın bütün özellikleri DocumentPrinterDelegation class' ına
 *  devredilir.
 *
 *  birden fazla interface' i bir araya getirerek ortak bir class oluşturur.
 */
class DocumentPrinterDelegation(private val printer: Printer, private val scanner: Scanner) : Printer by printer,
    Scanner by scanner

/**
 *  property delegation
 */
class Database {
    private val data = mutableMapOf<String, String>()

    fun saveData(key: String, value: String) {
        data[key] = value
        println("Saved '$value' with key '$key' to the database.")
    }

    fun loadData(key: String): String {
        return data[key] ?: "No data."
    }
}

class DatabaseDelegate(private val db: Database, private val key: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return db.loadData(key)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        return db.saveData(key, value)
    }

}

class User(db: Database) {
    var name: String by DatabaseDelegate(db, "name")
    var email: String by DatabaseDelegate(db, "email")
}

fun main() {
    val fancyScanner = FancyScanner()

    val inkPrinterD = InkPrinter()
    val documentInkPrinter = DocumentPrinterDelegation(inkPrinterD, fancyScanner)
    documentInkPrinter.printDocument()

    val laserPrinterD = LaserPrinter()
    val documentLaserPrinter = DocumentPrinterDelegation(laserPrinterD, fancyScanner)
    documentLaserPrinter.printDocument()

    val mixedPrinterD = MixedPrinter()
    val documentMixedPrinter = DocumentPrinterDelegation(mixedPrinterD, fancyScanner)
    documentMixedPrinter.printDocument()
    documentMixedPrinter.scan()
}