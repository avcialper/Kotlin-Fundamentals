package classes

/**
 *      Kotlin' de default olarak zaten bir encapsulation vardır.
 *
 *      Encapsulation' a göre, oluşturulan değişkenler ne derece açık olmalı, değişkenleri dışarıya açmak için hangi
 *      fonksiyonlar tanımlanacak, bu fonksiyonlar nerelerden erişilebilecek bunların belirlenmesi gerekir.
 *      Yani class' ın üyeleri dışarıya hangi seviyede açık olmalı, bunun belirlenmesi Encapsulation' dır.
 *
 *      Neden encapsulation yapılır;
 *          - Karmaşayı önlemek için. Belirli class' lar belirli class' lara tamamen erişebilmeli, bazı class'lar sadece
 *          belirli bölümlere erişebilmelidir. Eğer bir class' ın ana işyelişini etkileyen bölümler doğrudan dışarıya
 *          açılırsa class' ın özelliğinin bir amacı kalmaz ve istenmeyen sonuçlar ortaya çıkabilir.
 *          - Verilerin gizliliğini ve günveliğini sağlar. Sınıfın sadece yetkili fonksiyonlar tarafından değiştirilmesine
 *          izin verilir. Bu sayede verilerin bozulmasının önüne geçilir.
 *
 *      Kotlin' de bir property' nin private yapılması onun fonksiyonunun yazılıp yazılmamasını belirler. Yani
 *      eğer property (variable da denebilir) public ise bu değişkenler için (val var'a göre değişir) get ve set
 *      fonksiyonları arka planda tanımalnıyor. Eğer private yaparsak bu fonksiyon tanımlamaları yapılmıyor.
 *      Zaten değişkenler arka planda private olarak tanımlanmışlardır (backing field).
 *
 *      Fonksiyonların backing field' ı olmaz.
 *
 *      İncelemek için private ve public değişken oluşturup (val ve var halleri) show kotlin bytecode olarak incele.
 */
class Encapsulation {
    val name: String = "John"
    private val surname: String = "Doe"

    fun getFullName(): String {
        return "$name $surname"
    }
}