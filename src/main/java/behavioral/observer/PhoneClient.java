package behavioral.observer;

public class PhoneClient extends Observer {

    public PhoneClient(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("update from phone ");
    }

    @Override
    public void addMessage(String s) {
        subject.setState(s + " - sent from phone ");
    }
}
