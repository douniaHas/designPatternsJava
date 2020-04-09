package creational;

import creational.abstractFactory.CreditCard;
import creational.abstractFactory.CreditCardFactory;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AbstractFactoryTest {

    @Test
    public void shouldCreateDocument() throws ParserConfigurationException, IOException, SAXException {
        String xml = "<docName><body><stock>AAPL</stock></body></docName>";
        ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractFactory.newDocumentBuilder();
        Document document = factory.parse(stream);

        document.getDocumentElement().normalize();
        Assert.assertEquals("docName", document.getDocumentElement().getNodeName());
    }

    @Test
    public void shouldNotPayVisaCardScorePointLow(){
        CreditCardFactory abstractFactory = CreditCardFactory.create(400);
        CreditCard card = abstractFactory.getCard("GOLD");

        Assert.assertFalse(card.isPaid());
    }

    @Test
    public void shouldPayPlatinumCardScorePointLow(){
        CreditCardFactory abstractFactory = CreditCardFactory.create(400);
        CreditCard card = abstractFactory.getCard("PLATINUM");

        Assert.assertTrue(card.isPaid());
    }


}
