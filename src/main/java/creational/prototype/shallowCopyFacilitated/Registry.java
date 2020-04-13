package creational.prototype.shallowCopyFacilitated;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String, Item> items;

    //items cloned then modified at low cost
    public Registry(){
        this.items = loadItems();
    }

    public Registry clone(){
        Registry registry = new Registry();
        registry.items = new HashMap<>();
        try {
            registry.items.put("vegetable_cloned", (Item) createVegetable().clone());
            registry.items.put("fruit_cloned", (Item) createFruit().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return registry;
    }

    public Map<String, Item> loadItems(){
        Map map = new HashMap<String, Item>();
        map.put("star_vegetable", createVegetable());
        map.put("star_fruit", createFruit());
        return map ;
    }

    private Item createFruit() {
        Item fruit = new Fruit();
        fruit.setTitle("mango");
        return fruit;
    }

    private Item createVegetable() {
        Item vegetable = new Vegetable();
        vegetable.setPrice(Long.parseLong("20"));
        vegetable.setTitle("eggplant");
        return vegetable;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
