import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckedExceptions {
    public static void main(String[] args) {
/*
    Java'da 3 tür exception vardır.
    1- Checked Exceptions (Kontrollü İstisnalar) : Derleme anı istisnası da denir. (Compile Time Exceptions)
    Derleme anında ideler try catch bloğu göremediğinde fırlattığı hatalardır.
    Önceden önlem alınabilecek ve alınması gereken istisnalardır. Bu istisnalar network problemi gibi ya da
    erişilmek istenen bir dosyanın bulunmaması gibi çevresel faktörlerden de kaynaklı olabilir.
    Javada bu tür hataları gözardı etmek mümkün değildir.
    En yaygın kullanılan checked exceptionlar:
        1. IOException
        Açıklama: Giriş/çıkış işlemleri sırasında oluşan genel bir istisnadır.
        Kullanım Alanları: Dosya okuma/yazma işlemleri, ağ bağlantıları.
        2. FileNotFoundException
        Açıklama: Belirtilen dosya bulunamadığında fırlatılır.
        Kullanım Alanları: Dosya okuma/yazma işlemleri.
        3. SQLException
        Açıklama: Veri tabanı erişimi sırasında oluşan hatalar için kullanılır.
        Kullanım Alanları: Veri tabanı bağlantıları ve sorguları.
        4. ClassNotFoundException
        Açıklama: Belirtilen sınıf bulunamadığında fırlatılır.
        Kullanım Alanları: Dinamik sınıf yükleme işlemleri.
        5. InterruptedException
        Açıklama: Bir iş parçacığı (thread) kesildiğinde fırlatılır.
        Kullanım Alanları: Çok iş parçacıklı programlama.
        6. NoSuchMethodException
        Açıklama: Belirtilen yöntem bulunamadığında fırlatılır.
        Kullanım Alanları: Yansıma (reflection) işlemleri.
        7. NoSuchFieldException
        Açıklama: Belirtilen alan bulunamadığında fırlatılır.
        Kullanım Alanları: Yansıma (reflection) işlemleri.
        8. URISyntaxException
        Açıklama: URI'nın yanlış biçimlendirildiğinde fırlatılır.
        Kullanım Alanları: URI işleme.
        9. ParseException
        Açıklama: Bir string'in belirli bir biçime dönüştürülemediğinde fırlatılır.
        Kullanım Alanları: Tarih ve sayı biçimlendirme/parsing işlemleri.

    2- Unchecked Exceitons (Kontrolsüz İstisnalar) : Çalışma anı istisnası da denir.(Runtime Exceptions)
    Çalışma anında yakalanan, kontrolsüz kodlamadan kaynaklanan istisnalardır.
    Kontrolsüz kodlamaya örnek olarak ArrayIndexOutOfBoundsException verilebilir.
    Dizinin olmayan elemanına erişilmeye çalışıldığında bu hatayı verecektir.
    Fakat java compile sırasında bu hatayı yakalamaz. Bu tür istisnalara javada önlem alma zorunluluğu yoktur.

    En çok karşılaşılan kontrolsüz istisnalar :
      * ArithmeticException: Java matematiksel işlemler ile ilgili muhtemel tum istisna ve hataları ArithmeticException class’ına koymuştur. Dolayısı ile bir sayının sıfıra bölünmesi gibi matematiksel hatalarda, ArithmeticException fırlatılır.
      * NullPointerException: Java’da en çok karşılaşılan exception türlerinden bir tanesidir. Örneğin null bir değer sahip bir string’in length’i ölçmeye çalışan kod, NullPointerException verecektir.
      * ArrayIndexOutOfBoundsException: Array veya List’te bulunmayan bir index için işlem yapılmak istendiğinde Java ArrayIndexOutOfBoundsException hatası verir.
      * NumberFormatException: Sayı formatında olmayan bir String’i sayıya dönüştürmek istediğimiz Java, NumberFormatException hatası verir.
      * StringIndexOutOfBoundsException: Eğer bir String’den character/ler alırken olmayan bir index kullanılırsa, StringIndexOutOfBoundsException hatası verilir.
      * IllegalArgumentException: Genellikle throw yapmak için kullanılır. Geçersiz bir argüman girildiğinde, karşı tarafa IllegalArgumentException gönderilir. Örneğin yaş bilgisi negatif olarak girildiğinde, bu exception throw edilebilir.

    3- Error (Hata) :  Error, Throwable sınıfının bir alt sınıfıdır ve genellikle JVM (Java Virtual Machine) tarafından tespit edilen ciddi sorunları temsil eder.
       Bu hatalar genellikle uygulamanın normal çalışmasını engelleyen durumlardır.
       Error Sınıfının ÖzellikleriBazı hata örnekleri OutOfMemoryError, VirtualMachineError, AssertionError, StackOverflowError vb.'dir.

*/
        // IOException ve FileNotFoundException örneği
        try {
            FileReader file = new FileReader("example.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }

        // SQLException örneği
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }

        // ClassNotFoundException örneği
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }


        //ParseException --> Tarih Formatı Parse Örneği
        String dateStr = "2023-10-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse(dateStr);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Parse error: " + e.getMessage());
        }


        //ParseException --> Sayı Formatı Parse Örneği
        String numberStr = "1,234.56";
        NumberFormat nf = NumberFormat.getInstance();

        try {
            Number number = nf.parse(numberStr);
            System.out.println("Parsed number: " + number);
        } catch (ParseException e) {
            System.out.println("Parse error: " + e.getMessage());
        }

        //ParseException --> Özel Biçimlendirilmiş Metin Parse Örneği
        String pattern = "On {0}, a {1} occurred.";
        String message = "On 2023-10-15, a system crash occurred.";
        MessageFormat mf = new MessageFormat(pattern);

        try {
            Object[] parsed = mf.parse(message);
            System.out.println("Parsed date: " + parsed[0]);
            System.out.println("Parsed event: " + parsed[1]);
        } catch (ParseException e) {
            System.out.println("Parse error: " + e.getMessage());
        }

    }
}