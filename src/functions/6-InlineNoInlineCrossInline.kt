package functions

fun main() {

    /**
     *      Higher Order Function' lar kullanıldığı zaman, arka planda içerisine aldığı fonksiyon parametresine ait
     *      bir instance oluşturuluyor. Eğer bu instance' ın oluşturulmasını istemiyorsak bu Higher Order Function u
     *      inline keyword' ü ile belirtiriz. Bu şekilde parametre olarak gönderilen fonksiyonlar HOF içerine gömülür.
     *
     *      Mesela runAndPrint HOF içerisine bir adet run adında fonksiyon alıyor. HOF' u inline ile belirttiğimiz için
     *      fonksiyon içerisinde run' ın çağırıldığı alan arka planda direkt olarak fonksiyonun body'si olarak görünüyor.
     *      Bu sayede run fonksiyonun nesnesi üretilmiyor (instance' ı oluşturulmuyor), onun yerine fonksiyonun
     *      çağırıldığı alan body' si gibi davranıyor.
     *
     *      Bir HOF görece fazla kullanılıyorsa inline yapmak mantıklıdır. Ama sadece birkaç kez kullanılıyorsa inline
     *      yapılmasına gerek yoktur. Inline, programın derleme süresini arttırabilen bir yapıdır (eğer fonksiyon body' si
     *      büyükse, body büyükse derleme süresi uzar).
     */

    repeat(10) {
        runAndPrint {
            println(it)
        }
    }

    /**
     *      noinline ve crossinline kullanabilmek için HOF' un inline olarak tanımlanmış olması gerekmektedir.
     *
     *      Eğer bir HOF' un parametresindeki bir fonksiyonu başka bir HOF' a parametre olarak vermek istersek bu
     *      fonksiyonu inline yapamayız. Bunun için ya HOF' un içerisindeki fonksiyonu noinline yapmamız gerekiyor ya da
     *      diğer HOF' u (içerisine parametre olarak verdiğimiz ana HOF' un fonksiyon parametresini alan HOF) inline
     *      yapmamız gerekir.
     *
     *      inline olmayan HOF, parametre olarak arkaplanda o fonksiyonun bir nesnesini bekler. inline yapınca bir nesne
     *      beklemez, zaten o fonksiyonun body' si HOF' un içerisine eklenmiştir.
     */

    noinlineFun(
        {
            println(it)
        },
        {
            println(it)
        }
    )

    /**
     *      forEach bir inline Higher Order Function. Döngü içerisinde return değeri çalıştığı zaman uygulama döngüden çıkmakla
     *      kalmaz, aynı zamanda döngüyü saran fonksiyonda da çıkış yapar. Bu olaya non-local return denilir.
     *      Eğer bunu istemiyorsak label kullanmalıyız.
     *
     *      inline olmayan HOF' lar non-local return yapamazlar.
     *
     *      label kullanımı:
     *
     *      list.forEach labelName@ {
     *          if (it == 5) {
     *             return@labelName
     *          }
     *          println(it)
     *     }
     *
     *     Burada sadece forEach dışarısına çıkılır. Altta kalan işlemlere devam edilir.
     *
     */
    println("Start")
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    list.forEach {
        if (it == 5) {
            //return      // non-local return
            return@forEach
        }
        println(it)
        //  gizli bir return var
    }
    println("End")

    /**
     *      Eğer inline olan bir HOF (Higher-Order Function) içerisinde inline bir fonksiyon çağrılmak istenirse,
     *      IDE bu fonksiyon içerisinde non-local return olup olmadığını bilemez ve hata verir.
     *      Non-local return, bir fonksiyonun kendisinden daha dış bir fonksiyondan çıkış yapması anlamına gelir ve
     *      inline fonksiyonlar içinde bazen istenmeyen sonuçlar doğurabilir.
     *      Eğer biz inline HOF içerisine parametre olarak alınan fonksiyonu `crossinline` keyword'ü ile tanımlarsak,
     *      bu fonksiyon içerisinde non-local return olmadığını garanti eder hale geliriz.
     *
     *      crossinlie bir fonksiyon inline özelliklerine sahiptir. Tek farkı non-local return' e izin vermez. Hala bir
     *      instance oluşturmaz, body kullanır.
     *
     *      Eğer bir HOF' un parametre fonksiyonunu başka bir HOF' a parametre olarak geçirmek istiyorsak ve bu fonksiyon
     *      crossinline olarak tanımlanmış ise;
     *
     *      inline fun aFun(crossinline action:()->Unit){
     *          println("asd)
     *          bFun{
     *              action.invoke()
     *              action()
     *          }
     *          // bFun(action) // Çalışmaz
     *          println("asd")
     *      }
     *
     *      fun bFun(action: () -> Unit){
     *          action()
     *      }
     *
     *      şeklinde kullanabiliriz. Buradaki (aFun) action kesinlikle non-local değildir.
     *
     *
     */

    crossinlineFun {
        println("crossinlineFun")
        if (it.equals("kotlin")) {
            return@crossinlineFun
        }
        println(it)
    }

}

/**
 *      inline keyword'ü sadece Higher Order Function' larda kullanılabilir.
 *
 *      Higher Order Function' ların interface' lere göre bir performans artışı vardır. Bu performans artışı nasıl sağlanır?
 *          - inline keyword' ü kullanmak. inline keyword' ü kullanılarak parametre olarak geçilen fonksiyonun body' si,
 *          bu fonksiyonun HOF içerisinde çağırıldığı yere gömülmesini sağlar.
 *
 *      Hangi durumda inline kullanmamamız gerekir?
 *          - Parametre olarak alınan fonnksiyonun body' si büyükse derleme süreleri artar. Bu gibi durumlarda
 *          kullanılmamalı. Burada  HOF' un kullanım miktarıda önemlidir.
 */
inline fun runAndPrint(run: (String) -> Unit) {
    //  run.invoke("Message")   // Fonksiyon nullable olursa kullanılabilir. İkiside aynı işlem.
    run("Message")
}

/**
 *      noinline yapılarak nesnesi oluşturulmyan logger fonksiyonunun bir nesnesinin oluşturulmasını sağlıyoruz.
 */
inline fun noinlineFun(run: (String) -> Unit, noinline logger: (String) -> Unit) {
    log(logger)
    run("Message")
    log(logger)
}

/**
 *      İçerisine fonksiyonun bir nesnesini bekliyor.
 *      Bu fonksiyon çağırıldığı HOF içerisinde de yine bir nesne bekler. Ama HOF bir inline function ise parametre olarak
 *      aldığı fonksiyon bir nesne değildir. O fonksiyonun body' si zaten HOF' un içerisine eklenmiştir. inline içerisinden
 *      fonksiyon nesnesi almak istersek bu fonksiyonu noinline yapmamız gerekir.
 */
fun log(logger: (String) -> Unit) {
    logger("Start")
}

/**
 *      crossinlineFun HOF' u bir inline function. Yani action non-local return yapabilir.
 *      Ama biz action' ı crossinline ile tanımladığımız için bu fonksiyon içerisinde non-local return yapma işlemini
 *      kısıtladık.
 */
inline fun crossinlineFun(crossinline action: (String) -> Unit) {
    println("Start")
    anotherFun {
        /*
            action aslında bir function body' si gibi davranıyor.
            lambda expression dan bildiğimiz üzere, function body' leri () ve .invoke() şeklinde kullanılabilir.
            Bu sayade function' un non-local return içermediğini garantileyip işlem yapabiliyoruz.
         */
        action.invoke(it)
        // action(it)      // bu şekilde de kullanılabilir.
    }
    // anotherFun(action)   // Hata, anotherFun bizden bir adet fonksiyon instance' ı bekliyor. Ama crossinline bir instance değil.
    println("End")
}

fun anotherFun(action: (String) -> Unit) {
    action("kotlin")
}