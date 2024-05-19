import java.util.Random;

public class Hesap {
    private String id;
    private String isim;
    private String soyisim;
    private String telefonNumarasi;
    private String dogumTarihi; // aralarında "-"ler olmalıdır
    private String sifre; // 6 haneli olmalıdır
    private String iBan;
    private String hesapNumarasi; // 12 haneli olmalıdır
    private double hesapBakiyesi = 0;
    private int krediKarti = 0;

    Hesap(String id, String isim, String soyisim, String telefonNumarasi, String dogumGunu, String dogumAyi,
            String dogumYili, String sifre) {
        int yil = Integer.parseInt(dogumYili);
        boolean b = true;

        if (yil <= 1904) {
            System.out.println("120 yaşın üzerine banka hesabı açılmamaktadır.");
            b = false;
        }

        if (id.length() != 11) { //!TcKontrol.kontrol(id)
            System.out.println("Gecersiz bir TC kimlik numarası girdiniz!");
            b = false;
        }

        if (sifre.length() != 6) {
            System.out.println("Şifreniz 6 haneli olmalıdır!");
            b = false;
        }

        if (b) {
            StringBuilder dogumtarihi = new StringBuilder(10);
            dogumtarihi.append(dogumYili);
            dogumtarihi.append("-");
            dogumtarihi.append(dogumAyi);
            dogumtarihi.append("-");
            dogumtarihi.append(dogumGunu);
            this.setDogumTarihi(dogumtarihi.toString());
            this.setId(id);
            this.setIsim(isim);
            this.setSoyisim(soyisim);
            this.setTelefonNumarasi(telefonNumarasi);
            this.setSifre(sifre);
            hesapNumarasiOlusturucu();
            iBanOlusturucu();
        }
    }

    public Hesap(String id, String isim, String soyisim, String telefonNumarasi, String dogumTarihi, String sifre, String hesapNumarasi, double hesapBakiyesi, String iBan, int krediKarti) {
            this.setDogumTarihi(dogumTarihi);
            this.setId(id);
            this.setIsim(isim);
            this.setSoyisim(soyisim);
            this.setTelefonNumarasi(telefonNumarasi);
            this.setSifre(sifre);
            this.setHesapNumarasi(hesapNumarasi);
            this.setHesapBakiyesi(hesapBakiyesi);
            this.setiBan(iBan);
            this.setKrediKarti(krediKarti);
    }

    public String toString() {
        String hesap = "Hesap Sahibinin Adı Soyadı = " + this.getIsim() + " " + this.getSoyisim() +
                "\nHesap Sahibinin TC numarası = " + this.getId() +
                "\nHesap Sahibinin Doğum Tarihi = " + this.getDogumTarihi() +
                "\nHesap Sahibinin Bakiyesi = " + this.getHesapBakiyesi() +
                "\nHesap numarası = " + this.getHesapNumarasi() +
                "\niban numarası = " + this.getiBan() +
                "\nkredi kartı sayısı = " + this.getKrediKarti() +
                "\ntelefon numarası = " + this.getTelefonNumarasi() +
                "\nşifre = " + this.getSifre();
        return hesap;
    }

    public void paraYatir(double yatirilanPara) {
        // yatirilan para negatif olamaz
        if (yatirilanPara <= 0) {
            System.out.println("Gecersiz bir miktar girdiniz!");
        } else {
            this.setHesapBakiyesi(this.getHesapBakiyesi() + yatirilanPara);
            System.out.println("Bakiyeniz başarıyla yüklenmiştir.");
            System.out.println("Yeni bakiyeniz: " + this.getHesapBakiyesi());
        }
    }

    public void paraCek(double cekilenPara) {
        if (this.getHesapBakiyesi() >= cekilenPara) {
            this.setHesapBakiyesi(this.getHesapBakiyesi() - cekilenPara);
            System.out.println("Paranızı başarıyla çektiniz.");
            System.out.println("Yeni bakiyeniz: " + this.getHesapBakiyesi());
        } else {
            System.out.println("Para çekmek için yeterli bakiyeniz yok!");
        }
    }

    public void hesapNumarasiOlusturucu() {
        Random r = new Random();
        long gecici = r.nextLong(9999999999L, 1000000000000L);
        setHesapNumarasi(gecici + "");
    }

    public void iBanOlusturucu() {
        // BANKA KODUMUZ 39567
        String ibanBuilder = "TR" +
                "39567" +
                "0000000" +
                this.getHesapNumarasi();
        this.setiBan(ibanBuilder);
    }

    public void paraTransferi(Hesap obj, double miktar) {
        System.out.println("Para transferi ücretimiz 4.38TL dir.");
        if (this.getHesapBakiyesi() < miktar + 4.38) {
            System.out.println("Para göndermek için yeterli bekiyeniz yoktur");
        } else {
            this.setHesapBakiyesi(getHesapBakiyesi() - (miktar + 4.38));
            System.out.println("Kalan bakiyeniz = " + this.getHesapBakiyesi());
            obj.setHesapBakiyesi(obj.getHesapBakiyesi() + miktar);
        }
    }

    public void bankaKartiOlustur() {
        //BankaKarti bankaKarti = BankaKarti();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    public String getHesapNumarasi() {
        return hesapNumarasi;
    }

    public void setHesapNumarasi(String hesapNumarasi) {
        this.hesapNumarasi = hesapNumarasi;
    }

    public double getHesapBakiyesi() {
        return hesapBakiyesi;
    }

    public void setHesapBakiyesi(double hesapBakiyesi) {
        this.hesapBakiyesi = hesapBakiyesi;
    }

    public int getKrediKarti() {
        return this.krediKarti;
    }

    public void setKrediKarti(int krediKarti) {
        this.krediKarti = krediKarti;
    }
}
