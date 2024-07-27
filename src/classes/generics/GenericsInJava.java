package classes.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Öncelikli olarak Java' da Generic' ler invariant (değişmez) olarak bulunur.
 * Bunun anlamı List<String>, List<Object> 'nin bir alt tipi değildir.
 * Eğer List' ler invariant olmasaydı, Java' daki array' lerden bir farkı kalmazdı.
 */
public class GenericsInJava {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<String>();

        //  compile time hatası alırız.  type mismatch
        //  List<Object> objects = strings;

        //  Eğer hata almasaydık, int bir değeri string bir list' e atayabilirdik çünkü arayüzü object olacaktı.
        //  Her tipi kabul edebilecekti.
        // objects.add(1);

        //  Sonrasında string list' ten eleman alırken aslında int alacaktık ve bunu string değişkene vermeye çalışacaktık.
        //  Bu durumda da ClassCastException alırdık. Integer can not cas to String gibi.
        //  Java runtime safety' yi sağlamak için bunu engelliyor.
        // String s = objects.get(0);
    }

    void copyAll(Collection<Object> to, Collection<String> from) {
        //  Collection<String>, Collection<Object>' nin bir alt tipi olmadığından bunu yapamıyoruz.
        // to.addAll(from);
    }

    void copyAll2(Collection2<Object> to, Collection2<String> from) {
        to.addAll(from);    // String (from) Object' in (to) subtype' ı
    }

    void copyAll3(Collection3<Object> to, Collection3<String> from) {
        //  to.addAll(from);    // Object veya super type' larını verebiliriz. String, Object' in super type' ı değil.
    }

    interface Collection<E> {
        void addAll(Collection<E> items);
    }

    interface Collection2<E> {
        void addAll(Collection2<? extends E> items);
    }

    interface Collection3<E> {
        void addAll(Collection3<? super E> items);
    }

    /**
     *      Buradaki ? extends E ifadesi, E tipinde bir değişkeni ya da E' nin alt tiplerini de (subtype) kabul edildiğini
     *      ifade eder. BU sebeple, String normalde Object'i n bir alt sınıfı olduğundan yukarıdaki copyAll2 methodunda
     *      Object tipi veya onun alt tiplerini kabul edilmiş oluyor.
     *      Bu sebeple wildcard' ların extends-bound (upper bound) kullanımı burada tipi "Covariant" yapıyor.
     *      Özetle üst tipe sahip bir listeye alt türü' de atayabilmek şeklinde söyleyebiliriz.
     *
     *      Java' da ayrıca ? super String gibi wildcard kullanımı da vardır. (? wildcard)
     *      Bu da String ve super type' larını kabul ediyorum demektir. Bunda da "Contravariant" denmektedir.
     */
}
