package structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

    public String url;

    List<MenuComponent> components = new ArrayList<>();

    public String print(){
        return url + "\n";
    }
}
