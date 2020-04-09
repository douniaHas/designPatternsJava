package structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class OrderManagementSystem {

    Map<String, Item> items = new HashMap();

    public void takeOrder(String nameItem, int number){
        if(!items.containsKey(nameItem)){
            items.put(nameItem, new Item(number, nameItem));
        }
    }

    public int report(){
        return items.size();
    }
}

