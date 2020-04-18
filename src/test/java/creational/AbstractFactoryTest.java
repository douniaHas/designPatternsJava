package creational;

import creational.abstractFactory.Description;
import creational.abstractFactory.DescriptionGenerator;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Factory of factories. It's a composition pattern. For example, we want to get the description
 * of a professor of medecine job.
 * The client wants to get a result (the job description) and he participates by giving the appropriate information (field+job)
 * It's a framework pattern
 */
public class AbstractFactoryTest {

    @Test
    public void shouldCreateDocument() throws ParserConfigurationException, IOException, SAXException {
        String xml = "<docName><body><stock>AAPL</stock></body></docName>";
        ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractFactory.newDocumentBuilder();
        Document document = factory.parse(stream);

        document.getDocumentElement().normalize();
        assertEquals("docName", document.getDocumentElement().getNodeName());
    }

    @Test
    public void should_get_medecine_professor_job_description(){
        DescriptionGenerator generator = DescriptionGenerator.create("medecine");
        Description description = generator.getDescription("professor");

        assertEquals("Not yet specified",description.getTitle());
    }

    @Test
    public void should_get_law_student_job_description(){
        DescriptionGenerator generator = DescriptionGenerator.create("law");
        Description description = generator.getDescription("professor");

        assertEquals("Not yet specified",description.getTitle());
    }

}
