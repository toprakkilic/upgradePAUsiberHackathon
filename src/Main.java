import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        SqlConnect conn = new SqlConnect();

        int tercih = 0;
        do {
            String tcNumarasi;
            String sifre;
            System.out.println("------------------------------");
            System.out.println("Upgrade bank a hoşgeldiniz!");
            System.out.println("Giriş yapmak için 1 tuşuna basınız");
            System.out.println("Kayıt olmak için 2 tuşuna basınız");
            System.out.println("Programdan çıkmak için -1 tuşlayınız");
            System.out.println("------------------------------");
            tercih = scanner.nextInt();

            switch (tercih) {
                case 1:
                    System.out.println("TC numaranizi giriniz.");
                    tcNumarasi = scanner.nextLine();
                    System.out.println("Şifrenizi giriniz");
                    sifre = scanner.nextLine();
                    System.out.println("Girişiniz başarılı kullanıcı işlemlerine aktariliyorsunuz.");
                case 2:
                    tcNumarasi = scanner.nextLine();
                    System.out.println("Basariyla kayit olundu giriş yapıp işlemlerinize devam edebilirsiniz");
                    break;

                case -1:
                    System.out.println("Programdan cikis yapiliyor");
                    break;

                default:
                    System.out.println("Gecersiz bir işlem numarası girdiniz.");
                    break;
            }
        } while (tercih != -1);
    }
        public void kullaniciIslemleri (String TCNO) throws SQLException{
            // her seyden once sq ile kullamici belirlenmeli.
            SqlConnect conn = new SqlConnect();
            int secim = 0;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("------------------------------");
                System.out.println("1- Mevcut bakiye görüntüleme");
                System.out.println("2- Para yatırma");
                System.out.println("3- Para çekme");
                System.out.println("4- Para transferi");
                System.out.println("0- Hesaptan çıkış yap");
                System.out.println("------------------------------");
                secim = scanner.nextInt();

                switch (secim) {
                    case 1: conn.selectInf("tc", TCNO).getHesapBakiyesi(); 
                    break;
                    case 2: 
                        System.out.println("Yüklemek istediğiniz para miktarını girin = ");
                        double miktar = scanner.nextDouble();
                        conn.selectInf("tc", TCNO).paraYatir(miktar);
                        break;
                    case 3:
                        System.out.println("Çekmek istediğiniz para miktarını girin = ");
                        double miktar2 = scanner.nextDouble();
                        conn.selectInf("tc", TCNO).paraYatir(miktar2);
                        break;

                    case 4:
                        String gonderileniBan = scanner.nextLine();
                        double miktar3 = scanner.nextDouble();
                        conn.selectInf("tc", TCNO).paraTransferi(conn.selectInf("iBan", gonderileniBan), miktar3);
                        
                    case 0:
                    default: System.out.println("Geçersiz bir işlem numarası girdiniz. Tekrar deneyin");
                    break;

                }

            } while (secim != 0 || secim != 13);
        }

        public void hesapIslemleri (String TCNO){
            Scanner scanner = new Scanner(System.in);
            int secim = 0;

            do {
                System.out.println("------------------------------");
                System.out.println("1- Şifre değiştirme");
                System.out.println("2- Telefon numarası değiştirme");
                System.out.println("3- Hesap silme");
                System.out.println("4- Hesap bilgileri listeleme");
                System.out.println("0- Geri dönme");
                System.out.println("------------------------------");
                switch (secim) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 0:
                    default: System.out.println("Geçersiz bir işlem numarası girdiniz. Tekrar deneyin");
                }

            } while (secim != 0);

        }
        public void krediKartiIslemleri (String TCNO) throws SQLException{
            SqlConnect conn = new SqlConnect();
            Scanner scanner = new Scanner(System.in);
            int secim = 0;
            do {
                System.out.println("------------------------------");
                System.out.println("1- Kredi kartı borcu görüntüleme");
                System.out.println("2- Kredi kartı borcu ödeme");
                System.out.println("3- Kredi kartı limit arttırma");
                System.out.println("4- Kredi kartı başvurusu");
                System.out.println("5-Kredi kartı şifresi değiştirme");
                System.out.println("------------------------------");
                secim = scanner.nextInt();
                if(conn.selectInf("tc", TCNO).getKrediKarti() == 0){
                    System.out.println("Kredi kartınız olmadığı için kredi kartı işlemlerini kullanamazsınız.");
                    break;
                }

                switch(secim){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("Size kredi kartı verebilmemiz için maaşınız lazım =");
                        double maas = scanner.nextDouble();
                        conn.selectInf("tc", TCNO).krediKartiBasvur(conn.selectInf("tc", TCNO), maas);
                        break;
                    case 5:
                    case 0:
                    default:
                        System.out.println("Geçersiz bir işlem numarası girdiniz. Tekrar deneyin");
                        break;

                }

            } while (secim != 0);
        }

        public void krediIslemleri (String id){
            Scanner scanner = new Scanner(System.in);
            int secim = 0;
            do {
                System.out.println("------------------------------");
                System.out.println("1- Kredi borcu görüntüleme");
                System.out.println("2- Kredi başvurusu");
                System.out.println("0- Geri dön");
                System.out.println("------------------------------");

                secim = scanner.nextInt();

                switch(secim){
                    case 1:
                    case 2:
                    case 0:
                    default:
                        System.out.println("Geçersiz bir işlem numarası girdiniz. Tekrar deneyin");
                        break;
                }


            } while (secim != 0);
        }
}