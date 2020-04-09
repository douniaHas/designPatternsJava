package structural.composite;


import java.util.stream.Collectors;

public class Menu extends MenuComponent{

    public Menu(String url) {
        this.url = url;
    }

    public void add(MenuComponent component){
        components.add(component);
    }

    public String toString(){
        return print() + components.stream().map(c -> c.print()).collect(Collectors.joining());
    }

}
