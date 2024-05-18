public class BankaKarti extends Kart {

    public BankaKarti (Hesap obj) {
        super(obj);
    }

    public void HarcamaBankaKarti (Hesap obj, double tutar) {
        if (obj.getHesapBakiyesi() >= tutar) {
            obj.setHesapBakiyesi(obj.getHesapBakiyesi() - tutar);
            System.out.println("Harcama başarıyla yapıldı.");
            System.out.println("Yeni bakiyeniz: " + obj.getHesapBakiyesi());
        } else {
            System.out.println("Bakiyeniz yetersiz!");
        }
    }

}
