package classes.objects;

public class RetrofitInJava {
    private String baseUrl = "www.google.com";

    /**
     * Class içerisinde bir nesne tanımlıyoruz.
     * Nesneye class içerisindeki static fonksiyonlardan erişmek için static keyword' ü kullanıyoruz.
     * Private ta kalmalı, yoksa direkt olarak erişilebilir hale gelir.
     * volatile keyword' ü bu değişken üzerinde yapılan bütün değişiklikleri bütün thread' lere haber vermek için
     * kullanılır.
     */
    private volatile static RetrofitInJava newInstance;

    /**
     * Class' ın bütün constructor' larını private yaparak bu class' ın dışarıdan nesnesinin oluşturulmasını
     * engelleyebiliriz.
     */
    private RetrofitInJava() {

    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Class içerisinde oluşturulan nesneyi class dışına açmak için sadece get fonksiyonu tanımladık.
     * Eğer bir class fonksiyonuna o class' ın nesnesi olmadan erişmek istiyorsak, bu fonksiyonu static olarak
     * tanımlamalıyız.
     * Bu durumda da newInstance değişkenini de static olarak tanımlamamız gerekmektedir. Çünkü nesne oluşturulmadan bir
     * değere erişmeye çalışıyoruz.
     * synchronized keyword' ü bu fonksiyonun aynı anda sadece bir thread tarafından kullanılabilir olduğunu belirtmek
     * için kullanılır.
     */
    public synchronized static RetrofitInJava getNewInstance() {
        // newInstance değeri bir nesne taşımıyorsa yeni bir nesne tanımla.
        if (newInstance == null) {
            newInstance = new RetrofitInJava();
        }
        // Şeklinde block olarak ta tanımlanabilir
        // synchronized (RetrofitInJava.class) {}
        return newInstance;
    }
}
