
public class KrediKarti extends Kart{

    private double krediKartiLimiti;
    private double krediKartiBorcu = 0;
    private double maas;
    private double faizOrani = 5;    


    // kredi kartı limiti kişinin maaşının 3 katı olmalı
    public void KrediKartiBasvurusu(Hesap obj, Double maas) {
        if (maas > 5000){
            super.setBagliHesap(obj.getHesapNumarasi());
            super.CVCbelirleyici();
            super.KartNumarasiBelirleyici();
            super.KartNumarasiBelirleyici();
            System.out.println("Kredi karti cikartmaya uygunsunuz.");
            System.out.println("Limitiniz: " + maas * 3);
            this.maas = maas;
            krediKartiLimiti = maas * 3;
            
        } else {
            System.out.println("Kredi kartı çıkartmaya uygun değilsiniz!");
        }
    }
    public void limitArttirma(){
        double krediKartiLimiti = maas * 5;
        System.out.println("Kredi kartı limitinizi maaşınızın 5 katına çıkarttık");
        System.out.println("Kredi kartı limitinizi arttırmak Faiz oranınızı arttırır");
        faizOrani = faizOrani * 1.5;
        
    }


    public void krediKartiHarcama(double tutar){
        if(tutar <= krediKartiLimiti - krediKartiBorcu){
            krediKartiBorcu += tutar;
            System.out.println("Harcamanız başarıyla yapıldı.");
            System.out.println("Güncel borcunuz = " + krediKartiBorcu);
        }
        else{
            System.out.println("Limitiniz yetersiz olduğu için harcama yapamadınız!");
            System.out.println("İsterseniz limit arttırabilirsiniz.");
        }
    }

    public void krediKartiBorcOdeme(Hesap obj, double tutar){
        System.out.println("Her borc odedikten sonra borcunuza faiz eklenir");
        if(tutar <= obj.getHesapBakiyesi()){
            obj.setHesapBakiyesi(obj.getHesapBakiyesi() - tutar);
            krediKartiBorcu -= tutar;
            krediKartiBorcu = krediKartiBorcu * faizOrani / 30;
        }
        else{
            System.out.println("Kredi kartı borcunuzu ödemek için yeterli bakiyeniz yoktur.");
            System.out.println("Kredi kartı borcunuza faiz eklenmistir");
            krediKartiBorcu = krediKartiBorcu * faizOrani / 30;
        }

        
    }
}