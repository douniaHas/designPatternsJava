package structural;

import structural.Decorator.DressingDecorator;
import structural.Decorator.MeatDecorator;
import structural.Decorator.SimpleSandwich;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.fail;

public class DecoratorTest {

    /**
     * The Decorator pattern adds behavior to the base object (with composition)
     * without changing the existing concrete object nor the hierarchy
     * It adds functionality based on the base object (interface)
     * @throws IOException
     */

    @Test
    public void should_write_from_a_file()  {
        File file = new File("./output.txt");

        try {
            file.createNewFile();
            OutputStream oStream = new FileOutputStream(file);
            DataOutputStream doStream = new DataOutputStream(oStream);
            doStream.writeChars("hello");
            StringBuilder sb = readFromFile("./output.txt");

            Assert.assertNotNull(sb);
        } catch (IOException e) {
            fail();
        }

    }

    @Test
    public void should_add_meat_and_mustard_to_sandwich(){
        SimpleSandwich simpleSandwich = new SimpleSandwich();
        MeatDecorator meatDecorator = new MeatDecorator(simpleSandwich);

        String mySandwich = new DressingDecorator(meatDecorator).make();

        Assert.assertEquals("mustard meat sandwich", mySandwich);
    }

    private StringBuilder readFromFile(String file) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return sb;
    }
}
