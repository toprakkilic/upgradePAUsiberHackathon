import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    private String userName = "root";
    private String password = "Uph1824";
    private String dbUrl = "jdbc:mysql://localhost:3306/bankahesabi";
    public static void main(String[] args) throws SQLException{
        //Hesap hesap = new Hesap("11111111111", "isim", "soyisim", "05XXXXXXXXX", "05", "08", "2004", "123456");

        //System.out.println(hesap);
        //hesap.paraYatir(500);
        //System.out.println(hesap);
        SqlConnect conn = new SqlConnect();
        System.out.println((conn.selectInf("iBan","TR395670000000583716811725")).toString());


    }
}
