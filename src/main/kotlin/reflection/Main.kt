import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

class Account private constructor(var accountName: String) {
    private var balance: Long = 123456789

    private fun sendMoneyFromBalance(sentMoney: Long) {
        balance += sentMoney
    }
}

fun main() {
    // constructor ve member' ları private yaptığımız için hiçbirine erişemiyoruz.
//    val account = Account()
//    println(account.accountName)
//    println(account.balance)
//    account.sendMoneyFromBalance(123)
//    println(account.balance)

    // ClassName::class ile bir class hakkında birçok bilgiye erişebiliyoruz.
    // ClassName::class, KClass şeklinde bir class döner.
    val constructorsList = Account::class.constructors

    val primaryConstructor = Account::class.primaryConstructor
    primaryConstructor?.isAccessible = true
    val account: Account = primaryConstructor?.call("dummy account") as Account
    println(account.accountName)

    for (property in Account::class.memberProperties) {
        if (property.visibility == KVisibility.PRIVATE && property is kotlin.reflect.KMutableProperty<*>) {
            property.isAccessible = true
            if (property.name == "balance") {
                val balanceValue = property.getter.call(account)
                println("${property.name} = $balanceValue")
            }
        }
    }

}