package structural;

import structural.Decorator.DressingDecorator;
import structural.Decorator.MeatDecorator;
import structural.Decorator.SimpleSandwich;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DecoratorTest {

    @Test
    public void should_write_from_a_file() throws IOException {
        File file = new File("./output.txt");
        file.createNewFile();

        OutputStream oStream = new FileOutputStream(file);

        DataOutputStream doStream = new DataOutputStream(oStream);
        doStream.writeChars("hello");

        //InputStream iStream = new FileInputStream(file);

        //StringBuilder sb = readFromFile("./output.txt");

        doStream.close();
        oStream.close();

        //Assert.assertEquals("hello", sb);
    }

    @Test
    public void should_add_meat_and_mustard_to_sandwich(){
        String mySandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich())).make();
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
