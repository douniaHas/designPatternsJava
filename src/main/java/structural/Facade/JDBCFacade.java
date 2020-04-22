package structural.Facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFacade {

    private Connection connection;

    public JDBCFacade(Connection connection) {
        this.connection = connection;
    }

    public boolean createAdressesTable(){
        try {
        Statement sta = connection.createStatement();
        sta.executeUpdate("CREATE TABLE Address (ID INTEGER, StreetName "
                    + "VARCHAR(20), City VARCHAR(20))");

        sta.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public void addAdresses(){
        Statement sta = null;
        try {
            sta = connection.createStatement();
        int count = sta.executeUpdate("INSERT INTO Address (ID, StreetName, City) "
                + "values (1, '1234 Some street', 'Layton')");
        System.out.println(count + " record(s) created.");
        sta.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getAdresses(){
        try {
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
