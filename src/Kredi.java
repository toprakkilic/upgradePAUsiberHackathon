public abstract class Kredi {
    public double krediCarpani = 0.97;
    private double krediBorcu = 0;
    private double maas;


    public void KrediAl (Hesap obj, double maas) {
        if(obj.getKrediKarti() == 0) {
            System.out.println("Kredi kartınız olmadığı için kredi başvurusunda bulunamazsınız");
            System.out.println("Önce kredi kartına başvurmanız lazım");
        }else{
            
        }
    }

    public void ihtiyacKredisiAl(){

    }
}
