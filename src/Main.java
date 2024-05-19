import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException{
        Hesap hesap = new Hesap("32345678919", "isim", "soyisim", "05XXXXXXX29", "01", "01", "2004", "123456");
        hesap.paraYatir(500);
        //System.out.println(hesap);

        SqlConnect con = new SqlConnect();

        con.insertInf(hesap);

        con.updateInfStr(hesap, "sifre", "654321");

        con.updateInfN(hesap, "krediKarti", 1);

        con.deleteInf(hesap);



        //System.out.println(hesap);
        //SqlConnect conn = new SqlConnect();
        //System.out.println((conn.selectInf("iBan","TR395670000000583716811725")).toString());


    }
}
