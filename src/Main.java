import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException{
        Hesap hesap = new Hesap("12345678912", "isim", "soyisim", "05XXXXXXXX2", "01", "01", "2004", "123456");
        hesap.paraYatir(500);
        //System.out.println(hesap);

        SqlConnect con = new SqlConnect();
        con.insertInf(hesap);


        //System.out.println(hesap);
        //SqlConnect conn = new SqlConnect();
        //System.out.println((conn.selectInf("iBan","TR395670000000583716811725")).toString());


    }
}
