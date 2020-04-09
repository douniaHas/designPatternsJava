package behavioral;

import behavioral.observer.MessageStream;
import behavioral.observer.PhoneClient;
import behavioral.observer.Subject;
import behavioral.observer.TabletClient;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class ObserverTest {

    @Test
    public void should_notify_observers_someone_twitted() {
        TwitterStream stream = new TwitterStream();
        stream.addObserver(new Client());

        stream.publish();
    }

    @Test
    public void should_notify_tablet_and_phone_client_about_twitter_message(){
        Subject subject = new MessageStream();
        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("hello , this is my message ");
        tabletClient.addMessage("hello , this is another message ");
    }

    private class Client implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("someone updated : " + o);
        }
    }

    private class TwitterStream extends Observable {
        public void publish(){
            setChanged();
            notifyObservers();
        }
    }
}
