package structural;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import structural.Facade.JDBCFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;

public class FacadeTest {

    @Test
    public void should_grap_content_from_url() throws IOException {
        URL url = new URL("http", "app.pluralsight.com", 80, "/profile/author/bryan-hansen");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        String sumLine = "";

        while ((inputLine = in.readLine()) != null) {
            sumLine += inputLine;
        }
        Assert.assertNotEquals("", sumLine);

    }
    @Ignore
    @Test
    public void should_get_addresses_with_jdbc_connection() throws ClassNotFoundException {

        try {

            Connection conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","root");

            Statement sta = conn.createStatement();
            int count = sta.executeUpdate("CREATE TABLE Address (ID INTEGER, StreetName "
                    + "VARCHAR(20), City VARCHAR(20))");

            System.out.println("Table created.");
            sta.close();

            sta = conn.createStatement();
            count = sta.executeUpdate("INSERT INTO Address (ID, StreetName, City) "
                    + "values (1, '1234 Some street', 'Layton')");
            System.out.println(count + " record(s) created.");
            sta.close();

            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Ignore
    @Test
    public void createAdressesWithJBBCConnectionSimplified() throws ClassNotFoundException, SQLException {
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","root","root");
        JDBCFacade facade = new JDBCFacade(conn) ;
        facade.createAdressesTable();
        facade.addAdresses();
        facade.getAdresses();
    }
}
