package creational.factory;

public class PDF extends Document{

    public PDF() {
        this.setPrintable(true);
        this.setExtension(".pdf");
    }
}
