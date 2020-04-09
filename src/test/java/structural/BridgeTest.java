package structural;
import org.junit.Assert;
import org.junit.Test;
import structural.bridge.formatAndPrint.HTMLPrinter;
import structural.bridge.formatAndPrint.WebFormatter;
import structural.bridge.shape.Circle;
import structural.bridge.shape.Red;
import structural.bridge.shape.Square;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BridgeTest {

    @Test
    public void shouldDriverJDBCWork(){

                try {
                    //JDBC is an API
                    //DriverManager.registerDriver(new EmbeddedDriver()); // <- Driver

                    String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                    Connection conn = DriverManager.getConnection(dbUrl);

                    Statement sta = conn.createStatement();

                    //This client is an abstraction and can work with any database that has a driver
                    sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
                            + " City VARCHAR(20))");

                    System.out.println("Table created");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

    }

    @Test
    public void should_print_red_square(){
        Square square = new Square();
        Assert.assertEquals("RED", square.applyColor(new Red().applyColor()));
    }


    @Test
    public void should_print_red_circle(){
        Circle circle = new Circle();
        Assert.assertEquals("RED", circle.applyColor(new Red().applyColor()));
    }

    @Test
    public void should_print_blue_circle(){
        Circle circle = new Circle();
        Assert.assertEquals("BLUE", circle.applyColor("BLUE"));
    }

    @Test
    public void should_web_format_then_print_in_html(){
        String printed = new HTMLPrinter().print(new WebFormatter("Hello word"));
        Assert.assertEquals("<html><body>Oh ! Hello word !! </body></html>", printed);
    }
}
