package creational.factory;

public abstract class Document{
    private boolean printable;
    private String extension;

    public void setPrintable(boolean printable) {
        this.printable = printable;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
    public boolean isPrintable() {
        return printable;
    }
}
