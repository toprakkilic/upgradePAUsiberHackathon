import java.util.Random;

public class Hesap {
	private String id;
	private String isim;
	private String soyisim;
	private String telefonNumarasi;
	private String dogumTarihi; //aralarında -ler olamlı
	private String sifre; // 6 haneli olması gerekir
	private String iBan;
    private String hesapNumarasi; // 12 haneli olmali
	private double hesapBakiyesi = 0;


	Hesap(String id, String isim, String soyisim, String telefonNumarasi, int dogumGunu, int dogumAyi, int dogumYili, String sifre){
        StringBuilder dogumtarihi = new StringBuilder(10);
        if (dogumYili <1904){
            System.out.println("120 yaşın üzerine banka hesabı açamıyoruz.");
        }
        else {
            dogumtarihi.append(dogumYili);
            dogumtarihi.append("-");
            dogumtarihi.append(dogumAyi);
            dogumtarihi.append("-");
            dogumtarihi.append(dogumGunu);
            this.setDogumTarihi(dogumtarihi.toString());
        }
        if (TcKontrol.kontrol(id)){
            this.setId(id);
        }
        else {
            System.out.println("Gecersiz bir TC kimlik numarası girdiniz");
        }

		this.setIsim(isim);
		this.setSoyisim(soyisim);
		this.setTelefonNumarasi(telefonNumarasi);
		this.setSifre(sifre); // 6 haneli bir sayı olması lazım. 123456 gibi veya kişinin doğum tarihi olamaz, 0 ile başlayamaz.
	}

	public String toString(){
        StringBuilder sb = new StringBuilder();
		sb.append("Hesap Sahibinin Adı ve Soyadı = " + this.getIsim() + ", " + this.getSoyisim());
		sb.append("\nHesap Sahibinin TC numarası = " + this.getId());
		sb.append("\nHesap Sahibinin Doğum Tarihi = " + this.getDogumTarihi());
		sb.append("\nHesap Sahibinin Bakiyesi = " + this.getHesapBakiyesi());
        return sb.toString();
	}

	public void paraYatir(double yatirilanPara){
		// yatirilan para negatif olamaz
        if (yatirilanPara <= 0){
            System.out.println("Gecersiz bir miktar girdiniz");
        }
    else {
            this.setHesapBakiyesi(this.getHesapBakiyesi() + yatirilanPara);
            System.out.println("Bakiyeniz başarıyla yüklenmiştir.");
            System.out.println("Yeni bakiyeniz =" + this.getHesapBakiyesi());
        }
	}

	public void paraCek(double cekilenPara){
		if (this.getHesapBakiyesi() >= cekilenPara) {
			this.setHesapBakiyesi(this.getHesapBakiyesi() - cekilenPara);
			System.out.println("Paranızı başarıyla çektiniz.");
			System.out.println("Yeni bakiyeniz = " + this.getHesapBakiyesi());
		}
		else{
			System.out.println("Para çekmek için yeterli bakiyeniz yok :(");
		}
	}

    public void hesapNumarasiOlusturucu(){
        Random r = new Random();
        long gecici = r.nextLong(9999999999L, 1000000000000L);
        setHesapNumarasi(gecici + "");
    }

	public void iBanOlusturucu(){
        // BANKA KODUMUZ 39567
		StringBuilder ibanBuilder = new StringBuilder(26);
        ibanBuilder.append("TR");
        ibanBuilder.append("39567");
        ibanBuilder.append("000000");
        ibanBuilder.append(this.getHesapNumarasi());
        this.setiBan(ibanBuilder.toString());
	}

    public void paraTransferi(Hesap obj, double miktar){
        System.out.println("Para transferi ücretrimiz 4.38TL dir.");
        if (getHesapBakiyesi() < miktar + 4.38){
            System.out.println("Para göndermek için yeterli bekiyeniz yoktur");
        }
        else {
            setHesapBakiyesi(getHesapBakiyesi() - (miktar + 4.38));
            System.out.println("Kalan bakiyeniz = " + getHesapBakiyesi());
            obj.setHesapBakiyesi(obj.getHesapBakiyesi() + miktar);
        }
    }

    public void bankaKartiBasvur(){

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
}
