public class Main {
    public static void main(String[] args) {
        Hesap hesap = new Hesap("13904997574", "bartu", "sarı", "5468665856", "05", "08", "2004", "123456");

        System.out.println(hesap);
        hesap.paraYatir(500);
        System.out.println(hesap);
        Kredi kredi = new Kredi();
    }
}