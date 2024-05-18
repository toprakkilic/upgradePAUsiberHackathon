import java.util.Random;

public abstract class Kart {
    Random r = new Random();
    private String CVC;
    private String SKT;
    private String Sifre;
    private String KartNumarasi;
    private String bagliHesap;

    public Kart(Hesap obj){
        this.setBagliHesap(obj.getHesapNumarasi());
        CVCbelirleyici();
        SKTbelirleyici();
        KartNumarasiBelirleyici();

    }

    public void CVCbelirleyici(){
        this.setCVC(r.nextInt(99, 999) + "");
    }

    public void SKTbelirleyici(){
        this.setSKT(23052005 + "");
    }

    public void KartNumarasiBelirleyici(){
        Random random = new Random();
        long gecici = random.nextLong(999999999999999L, 10000000000000000L);
        this.setKartNumarasi(gecici + "");
    }


    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getSKT() {
        return SKT;
    }

    public void setSKT(String SKT) {
        this.SKT = SKT;
    }

    public String getKartNumarasi() {
        return KartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        KartNumarasi = kartNumarasi;
    }

    public String getBagliHesap() {
        return bagliHesap;
    }

    public void setBagliHesap(String bagliHesap) {
        this.bagliHesap = bagliHesap;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }
}
