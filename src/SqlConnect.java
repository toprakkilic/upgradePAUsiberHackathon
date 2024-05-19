import java.sql.*;

public class SqlConnect {
    private final String userName = "root";
    private final String password = "1234";
    private final String dbUrl = "jdbc:mysql://localhost:3306/bankahesabi";

    public SqlConnect() {

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public static Hesap selectInf(String rowname, String sart) throws SQLException {
        Connection connection = null;
        SqlConnect helper = new SqlConnect();
        Statement statement = null;
        ResultSet resultSet;
        Hesap hesap = null;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select hesapNumarasi,isim,soyisim,telefonNumarasi,dogumTarihi,sifre,iBan,tc,hesapBakiyesi,krediKarti from bankahesabi.hesap where " + rowname + " = '" + sart + "'");
            while (resultSet.next()) {
                hesap = new Hesap(resultSet.getString("tc"),
                        resultSet.getString("isim"),
                        resultSet.getString("soyisim"),
                        resultSet.getString("telefonNumarasi"),
                        resultSet.getString("dogumTarihi"),
                        resultSet.getString("sifre"),
                        resultSet.getString("hesapNumarasi"),
                        resultSet.getDouble("hesapBakiyesi"),
                        resultSet.getString("iBan"),
                        resultSet.getInt("krediKarti"));
            }
            System.out.println("Bağlandı ve veriler Girildi");
        } catch (SQLException exc) {
            helper.showErrorMsg(exc);
        } finally {
            connection.close();
            statement.close();
            System.out.println("bağlantı sonlandı");
            return hesap;
        }
    }

    public static void insertInf(Hesap hesap) throws SQLException {
        Connection connection = null;
        SqlConnect helper = new SqlConnect();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "insert into bankahesabi.hesap (hesapNumarasi,isim,soyisim,telefonNumarasi,dogumTarihi,sifre,iBan,tc,hesapBakiyesi,krediKarti) values(?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, hesap.getHesapNumarasi());
            statement.setString(2, hesap.getIsim());
            statement.setString(3, hesap.getSoyisim());
            statement.setString(4, hesap.getTelefonNumarasi());
            statement.setString(5, hesap.getDogumTarihi());
            statement.setString(6, hesap.getSifre());
            statement.setString(7, hesap.getiBan());
            statement.setString(8, hesap.getId());
            statement.setDouble(9, hesap.getHesapBakiyesi());
            statement.setInt(10, hesap.getKrediKarti());
            int result = statement.executeUpdate();

        } catch (SQLException exc) {
            helper.showErrorMsg(exc);
        } finally {
            connection.close();
            statement.close();
            System.out.println("bilgiler girildi");
        }
    }

    public static void updateInfStr(Hesap hesap, String rowname, String deger) throws SQLException {
        Connection connection = null;
        SqlConnect helper = new SqlConnect();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "update bankahesabi.hesap set " + rowname + "=" + "'" + deger + "'" + " where hesapNumarasi = " + hesap.getHesapNumarasi() + ";";
            statement = connection.prepareStatement(sql);
            int result = statement.executeUpdate();

        } catch (SQLException exc) {
            helper.showErrorMsg(exc);
        } finally {
            connection.close();
            statement.close();
            System.out.println("bilgiler girildi");
        }
    }

    public static void updateInfN(Hesap hesap, String rowname, int deger) throws SQLException {
        Connection connection = null;
        SqlConnect helper = new SqlConnect();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "update bankahesabi.hesap set " + rowname + "=" + deger + " where hesapNumarasi = " + hesap.getHesapNumarasi() + ";";
            statement = connection.prepareStatement(sql);
            int result = statement.executeUpdate();

        } catch (SQLException exc) {
            helper.showErrorMsg(exc);
        } finally {
            connection.close();
            statement.close();
            System.out.println("bilgiler girildi");
        }
    }

    public static void deleteInf(Hesap hesap) throws SQLException {
        Connection connection = null;
        SqlConnect helper = new SqlConnect();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "delete from bankahesabi.hesap where hesapNumarasi = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,hesap.getHesapNumarasi());
            int result = statement.executeUpdate();
            System.out.println("kayıt silindi");
        } catch (SQLException exc) {
            helper.showErrorMsg(exc);
        } finally {
            connection.close();
            statement.close();
        }
    }


    public void showErrorMsg(SQLException exception) {
        System.out.println("Error : " + exception.getMessage());
        System.out.println("Error Code : " + exception.getErrorCode());
    }

}
