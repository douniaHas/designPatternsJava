package structural.bridge.formatAndPrint;

import structural.bridge.shape.Printer;

public class HTMLPrinter extends Printer {
    @Override
    public String print(Formatter formatter) {
        return "<html><body>"+ formatter.format() + "</body></html>";
    }

}
