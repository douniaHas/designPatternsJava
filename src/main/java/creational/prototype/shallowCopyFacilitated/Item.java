package creational.prototype.shallowCopyFacilitated;

//shallow clone
public abstract class Item implements Cloneable{
    private String title = "title";
    private Long price = Long.parseLong("10");
    private String URL = "http://www.amazon.com";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
