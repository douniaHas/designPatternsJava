package behavioral.observer;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageStream extends Subject {
    Deque<String> history = new ArrayDeque<>();

    @Override
    void setState(String message) {
        history.add(message);
        notifyObservers();
    }

    @Override
    String getState() {
        return history.getLast();
    }

}
