package structural;

import org.junit.Assert;
import org.junit.Test;
import structural.bridge.formatAndPrint.HTMLPrinter;
import structural.bridge.formatAndPrint.WebFormatter;
import structural.bridge.shape.Blue;
import structural.bridge.shape.Circle;
import structural.bridge.shape.Red;
import structural.bridge.shape.Square;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BridgeTest {

    /**
     * The main purpose is to make abstraction and implementation independents
     * The client has a basic abstraction and can specify behavior .
     * Designed up-front. Gives a lot of flexibility and extension for the creation of new objects
     * with the help of abstract classes
     * Uses composition (so the bridge)
     * Similar to Adapter with the difference that Bridge works with new code and Adapter works with legacy code
     */

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
        Red red = new Red();
        Assert.assertEquals("RED", square.applyColor(red.fill()));
    }


    @Test
    public void should_print_red_circle(){
        Circle circle = new Circle();
        Red red = new Red();
        Assert.assertEquals("RED", circle.applyColor(red.fill()));
    }

    @Test
    public void should_print_blue_circle(){
        Circle circle = new Circle();
        Blue blue = new Blue();
        Assert.assertEquals("BLUE", circle.applyColor(blue.fill()));
    }

    @Test
    public void should_web_format_then_print_in_html(){
        String printed = new HTMLPrinter().print(new WebFormatter("Hello word"));
        Assert.assertEquals("<html><body>Oh ! Hello word !! </body></html>", printed);
    }
}
