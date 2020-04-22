package structural;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import structural.proxy.SecurityProxy;
import structural.proxy.TwitterService;
import structural.proxy.TwitterServiceImpl;
import structural.proxy.TwitterServiceStub;

public class ProxyTest {
    /**
     * we use a construction of Proxy offered by java.lang.reflect
     * The Proxy pattern is used to create a simple interface for simplicity, security, remote concerns.
     * Behavior can be added, restrictions to calls to the object we want to hide too but it's not a decorator pattern.
     * http://twitter4j.org/en/index.html
     * https://developer.twitter.com/en
     * https://docs.inboundnow.com/guide/create-twitter-application/
     */
    @Test
    public void should_get_twitter_message_from_stub(){
        TwitterService twitterService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
        Assert.assertEquals("hello",twitterService.getTimeline());
    }

    /**
     *should work when you will put on your twitter app credentials
     */
    @Ignore
    @Test
    public void should_get_twitter_message_from_real_twitter_api(){
        TwitterService twitterService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());
        Assert.assertTrue(twitterService.getTimeline().contains("yma_screenname"));
    }

    @Test(expected = RuntimeException.class)
    public void should_not_allow_post_through_twitter(){
        TwitterService twitterService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());
        twitterService.postTimeline("hello word");
    }
}
