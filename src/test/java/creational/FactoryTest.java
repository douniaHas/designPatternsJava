package creational;

import creational.factory.Document;
import creational.factory.DocumentFactory;
import creational.factory.DocumentType;
import org.junit.Test;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class FactoryTest {
    /**
     * The infrastructure defines the factory which is in charge of the creation of the objects.
     * The client get to the creation of the objects through the factory. He is not aware of how things are wired.
     * Interface driven. There is a cost of creating the factory but compensated by the
     * flexibility of the creation of a new type of client.
     */

    @Test
    public void should_get_current_calendar_year(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.systemDefault()));
        assertEquals(2020, cal.get(Calendar.YEAR));
    }


    @Test
    public void should_pdf_document_created_have_pdf_extension(){
        Document document = new DocumentFactory().create(DocumentType.PDF);
        assertEquals(".pdf", document.getExtension());
        assertTrue(document.isPrintable());
    }

    @Test
    public void should_txt_document_created_have_txt_extension(){
        Document document = new DocumentFactory().create(DocumentType.TXT);
        assertEquals(".txt", document.getExtension());
        assertFalse(document.isPrintable());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_html_document_not_be_created(){
        new DocumentFactory().create(DocumentType.HTML);
    }
}
