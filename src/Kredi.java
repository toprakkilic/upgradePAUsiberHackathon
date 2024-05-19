import java.util.Scanner;
public class Kredi {
    private double krediBorcu = 0;
    private double maas;
    private double maxkrediMiktari;
    public double faizOrani = 2.49;




    public void KrediAl (Hesap obj) {

        Scanner scanner = new Scanner(System.in);
        double alinanKrediMiktari;
        if(obj.getKrediKarti() == 0) {
            System.out.println("Kredi kartınız olmadığı için kredi başvurusunda bulunamazsınız");
            System.out.println("Önce kredi kartına başvurmanız lazım");
        }else{
            System.out.println("Alabileceginiz maksimum kredi miktari = " + maxkrediMiktari);
            System.out.println("Almak istediğiniz kredi miktarini girin =");
            alinanKrediMiktari = scanner.nextDouble();

            if (alinanKrediMiktari > maxkrediMiktari) {
                System.out.println("Size verdiğimiz limitten fazla kredi alamazsiniz !");
            }
            else{
                System.out.println("Kredinizi başarıyla aldınız.");
                this.krediBorcu = alinanKrediMiktari;
            }

        }
    }
    public void krediBorcuOdeme(Hesap obj){
        double odemeMiktari;
        Scanner scanner = new Scanner(System.in);
        krediBorcu += krediBorcu * faizOrani / 12;
        System.out.println("Kalan kredi borcunuz" + krediBorcu);
        System.out.println("Odemek istediginiz kredi miktarini giriniz.");
        System.out.println("Minimum %20 sini odeyebilirsiniz");
        odemeMiktari = scanner.nextDouble();

        if(odemeMiktari > obj.getHesapBakiyesi()){
            System.out.println("Odemek icin yeterli bakiyeniz yoktur");
        }
        else if (odemeMiktari < krediBorcu / 5) {
            System.out.println("Kredi borcunuzun en az %20 sini odeyebilirsiniz");
        }
        else if (odemeMiktari > krediBorcu) {
            System.out.println("Borcunuzdan fazla miktarı ödeyemezsiniz !");
        }
        else {
            krediBorcu -= odemeMiktari;
            System.out.println("Kredi borcunuzun bir kismi odenmistir ");
            System.out.println("Kalan kredi borcunuz = " + krediBorcu);

        }








    }


}
