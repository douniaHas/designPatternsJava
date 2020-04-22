package structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class Catalog {

    private Map<String, Item> items = new HashMap();

    public Item lookup(String nameItem) {
        Item item;
        if(!items.containsKey(nameItem)){
            item = new Item(nameItem);
            items.put(nameItem, item);
        }
        else{
            item = items.get(nameItem);
        }
        return item;
    }

    public int report() {
        return items.size();
    }
}
