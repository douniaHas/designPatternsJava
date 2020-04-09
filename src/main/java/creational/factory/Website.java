package creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {
    private List<String> pages = new ArrayList<>();

    public List<String> getPages() {
        return pages;
    }
}
