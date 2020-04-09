package structural.proxy;

public class TwitterServiceStub implements TwitterService {

    @Override
    public String getTimeline() {
        return "hello";
    }

    @Override
    public void postTimeline(String message) {

    }
}
