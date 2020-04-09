package creational;

import creational.factory.Type;
import creational.factory.Website;
import creational.factory.WebsiteFactory;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class FactoryTest {

    @Test
    public void shouldGetCalendarFactoryDayOfMonth(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.systemDefault()));
        Assert.assertEquals(2020, cal.get(Calendar.YEAR));
    }

    @Test
    public void shouldCreateBlogWebsite(){
        Website blog = new WebsiteFactory().create(Type.BLOG);
        Assert.assertTrue(blog.getPages().contains("contact"));
    }

    @Test
    public void shouldCreateShopWebsite(){
        Website blog = new WebsiteFactory().create(Type.SHOP);
        Assert.assertTrue(blog.getPages().contains("CartPage"));
    }


}
