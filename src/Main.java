import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String tcNumarasi;
        int tercih = 0;
        do {
            System.out.println("Upgrade bank a hoşgeldiniz!");
            System.out.println("Giriş yapmak için 1 tuşuna basınız");
            System.out.println("Kayıt olmak için 2 tuşuna basınız");
            System.out.println("Programdan çıkmak için -1 tuşlayınız");
            tercih = scanner.nextInt();

            switch (tercih) {
                case 1:
                    System.out.println("TC numaranizi giriniz.");
                    tcNumarasi = scanner.nextLine();
                    System.out.println("Girişiniz başarılı kullanıcı işlemlerine aktariliyorsunuz.");


                case 2:
                    System.out.println("Basariyla kayit olundu giriş yapıp işlemlerinize devam edebilirsiniz");

                case -1:
                    System.out.println("Programdan cikis yapiliyor");


                default:
                    System.out.println("Gecersiz bir işlem numarası girdiniz.");
            }
        } while (tercih != -1);
    }
        public void kullaniciIslemleri (String TCNO){
            // her seyden once sq ile kullamici belirlenmeli.
            int secim = 0;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1- Mevcut bakiye görüntüleme");
                System.out.println("2- Para yatırma");
                System.out.println("3- Para çekme");
                System.out.println("4- Para transferi");
                System.out.println("11");

                System.out.println("0- Hesaptan çıkış yap");
                secim = scanner.nextInt();

                switch (secim) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 13:
                    case 0:
                    default:

                }

            } while (secim != 0 || secim != 13);
        }

        public void hesapIslemleri (String TCNO){
            Scanner scanner = new Scanner(System.in);
            int secim = 0;

            do {
                System.out.println("1- Şifre değiştirme");
                System.out.println("2- Telefon numarası değiştirme");
                System.out.println("3- Hesap silme");
                System.out.println("0- Geri dönme");
                switch (secim) {
                    case 1:
                    case 2:
                    case 3:
                    case 0:
                    default:
                }

            } while (secim != 0);

        }
        public void krediKartiIslemleri (String id){
            Scanner scanner = new Scanner(System.in);
            int secim = 0;
            do {

                System.out.println("1- Kredi kartı borcu görüntüleme");
                System.out.println("2- Kredi kartı borcu ödeme");
                System.out.println("3- Kredi kartı limit arttırma");
                System.out.println("4- Kredi kartı başvurusu");
                System.out.println("Kredi kartı şifresi değiştirme");

            } while (secim != 0);
        }

        public void krediIslemleri (String NO){
            Scanner scanner = new Scanner(System.in);
            int secim = 0;
            do {
                System.out.println("1- Kredi borcu görüntüleme");
                System.out.println("2- Kredi başvurusu");
                System.out.println("0- Geri dönme");


            } while (secim != 0);
        }
}