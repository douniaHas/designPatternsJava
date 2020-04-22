package structural;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import structural.Facade.JDBCFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class FacadeTest {

    /**
     * The Facade Pattern is used to hide the complexity and dependencies (give a simple facade) for the client
     * All the complex logic is hidden in a separate class
     * It's useful for legacy systems where we care more about the interface than about the content and the logic behind
     * It's a refactoring Pattern
     * @throws IOException
     */
    @Mock
    private Connection mockConnection;
    @Mock private Statement mockStatement;

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


    @Test
    public void should_create_addresses_with_JBBC_Connection_Simplified() throws ClassNotFoundException, SQLException {
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        JDBCFacade facade = new JDBCFacade(mockConnection);

        assertTrue(facade.createAdressesTable());
    }
}
