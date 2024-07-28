package classes.objects;

/**
 * Singleton pattern nedir?
 * - memory' de tek bir obje olmasını istediğimiz zamanlarda bu sınıfı singleton pattern ile yazarız. Bu oluşturulan
 * objenin yönetimi bizim elimizde olur ve Garbage Collector bu nesneyi silemez. Bu nesnenin yönetimi tamamen bizim
 * elimizde olur. Bu sayede uygulamanın herhangi bir yerinde bu nesneye ulaşmak istediğimizde hep aynı nesneye ulaşırız.
 * Tek bir nesne üzerinden birden fazla ekranda işlem yapabiliriz.
 * <p>
 * Anti pattern durumu nedir?
 * - Çok sayıda singleton pattern nesne tanımlanması halinde kullanılmayan nesneler hafızada boşa alan kaplayabilirler.
 * Bu nesnelerin hafızadan temizlenmemesi durumunda bellek kullanımı artar. Bunun için ya singleton nesnelerin değerleri
 * temizlenmeli ya da bu nesneler için singleton pattern kullanılmamalı.
 * - Singleton nesnenin güncel olup olmadığı kontrol edilmeli. Aksi halde güncel olmayan veriler ile işlem yapılabilir ve
 * istenmeyen sonuçlar elde edilebilir.
 * <p>
 * Singleton Pattern nasıl oluşturulur?
 * 1- Class' ın constructor' larını private olarak tanımlanmalı. Bu sayede class' ın dışarıdan bir nesnesinin oluşturulmasını
 * engellemiş oluyoruz.
 * 2- Class içerisinde bir adet class instance' ı oluştur.
 * 3- Oluşturulan instance' ı geri dönen bir static fonksiyon tanımla. Dışarıdan class' ın nesnesini oluşturamadığımız
 * için fonksiyon static olmalı.
 * 4- Fonksiyon içerisinde instance için null check yap. Bu sayede fonksiyon her çağırıldığında nesne yeniden oluşturulmaz.
 * Oluşturulan instance değeri geri dönüleceği için de bu değeri static tanımla.
 * <p>
 * Thread safety nasıl sağlanır?
 * - Fonksiyon synchronized keyword' ü ile tanımlanmalı. Bu sayede bu fonksiyon aynı anda sadece bir thread tarafından
 * kullanılabilir hale gelir.
 * - Class instance' ını da volatile ile tanımlayabiliriz. Bu keyword bu nesneyi kullanan bütün thread' lere nesne üzerinde
 * bir değişim olduğunda bu değişimi bildirir.
 */
public class SingletonObjectInJava {
    public static void main(String[] args) {
        RetrofitInJava retrofit = RetrofitInJava.getNewInstance();
        String baseUrl = retrofit.getBaseUrl();
        System.out.println(baseUrl);
    }
}
