package structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

public class OrderManagementSystem {
    private Catalog catalog = new Catalog();
    private List<Order> orders = new ArrayList<Order>();


    public void takeOrder(String nameItem, int orderNumber){
        Item item = catalog.lookup(nameItem);
        orders.add(new Order(item.getName(),orderNumber));
    }

    public int report(){
        return catalog.report();
    }
}

