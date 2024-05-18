import java.sql.*;
import java.util.ArrayList;

public class SqlConnect {
    private String userName = "root";
    private String password = "Uph1824";
    private String dbUrl = "jdbc:mysql://localhost:3306/denemeuser";

    public SqlConnect(){

    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    public static void selectInf() throws SQLException{

        Connection connection = null;
        SqlConnect helper = new SqlConnect();
        Statement statement = null;
        ResultSet resultSet ;
        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select hesapNumarasi,isim,soyisim,telefonNumarasi,dogumTarihi,sifre,iBan,tc,hesapBakiyesi,krediKarti from bankahesabi.hesap");
            ArrayList<Hesap> users = new ArrayList<Hesap>();
            while(resultSet.next()){
                users.add(new Hesap(resultSet.getString("tc"),
                        resultSet.getString("isim"),
                        resultSet.getString("soyisim"),
                        resultSet.getString("telefonNumarasi"),
                        resultSet.getString("dogumTarihi"),
                        resultSet.getString("sifre"),
                        resultSet.getString("hesapNumarasi"),
                        resultSet.getDouble("hesapBakiyesi"),
                        resultSet.getString("iBan"),
                        resultSet.getInt("krediKarti")));
            }
        }catch (SQLException exc){
            helper.showErrorMsg(exc);
        }finally {
            connection.close();
            System.out.println("bağlantı sonlandı");
        }
    }
    public void showErrorMsg(SQLException exception){
        System.out.println("Error : "+exception.getMessage());
        System.out.println("Error Code : "+exception.getErrorCode());
    }

}
