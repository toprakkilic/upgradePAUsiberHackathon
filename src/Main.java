public class Main {
    public static void main(String[] args) {
        Hesap hesap = new Hesap("11111111111", "isim", "soyisim", "05XXXXXXXXX", "05", "08", "2004", "123456");

        System.out.println(hesap);
        hesap.paraYatir(500);
        System.out.println(hesap);
        Kredi kredi = new Kredi();
    }
}
