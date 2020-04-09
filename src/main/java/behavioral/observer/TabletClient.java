package behavioral.observer;

public class TabletClient extends Observer {

    public TabletClient(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("update from tablet ");
    }

    @Override
    public void addMessage(String s) {
        subject.setState(s + " - sent from tablet ");
    }
}
