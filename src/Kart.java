import java.util.Random;

public abstract class Kart {
    Random r = new Random();
    private String CVC;
    private String  SKT;
    private String Sifre;
    private String KartNumarası;
    private String bagliOlunanHesap;

    public void CVCbelirleyici(){
        this.setCVC(r.nextInt(99, 999) + "");
    }

    public void SKTbelirleyici(){
        this.setSKT(23052005 + "");
    }

    public void KartNumarasıBelirleyici(){
        this.setKartNumarası("T");
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

    public String getKartNumarası() {
        return KartNumarası;
    }

    public void setKartNumarası(String kartNumarası) {
        KartNumarası = kartNumarası;
    }

    public String getBagliOlunanHesap() {
        return bagliOlunanHesap;
    }

    public void setBagliOlunanHesap(String bagliOlunanHesap) {
        this.bagliOlunanHesap = bagliOlunanHesap;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }
}
