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
            registry.items.put("movie_cloned", (Item) createMovie().clone());
            registry.items.put("book_cloned", (Item) createBook().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return registry;
    }

    public Map<String, Item> loadItems(){
        Map map = new HashMap<String, Item>();
        map.put("movie_star", createMovie());
        map.put("book_star", createBook());
        return map ;
    }

    private Item createBook() {
        Item movie = new Book();
        movie.setTitle("Dune");
        return movie;
    }

    private Item createMovie() {
        Item movie = new Movie();
        movie.setPrice(Long.parseLong("20"));
        movie.setTitle("Happiness therapy");
        return movie;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
