package structural.bridge.formatAndPrint;

public class WebFormatter extends Formatter {

    private String message;

    public WebFormatter(String message){
        this.message = message;
    }

    @Override
    public String format() {
        return "Oh ! " + message + " !! ";
    }
}
