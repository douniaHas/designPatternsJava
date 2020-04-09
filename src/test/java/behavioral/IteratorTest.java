package behavioral;

import behavioral.Iterator.BikeRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class IteratorTest {

    @Test
    public void should_test_iterator(){//TODO : voir pourquoi ca ne marche pas pour arrays.asList
        List<String> names = new ArrayList<>();// = Arrays.asList("david", "bob");
        //Set<String> names = new HashSet<>();
        names.add("david");
        names.add("bob");
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            iterator.remove();
        }


        Assert.assertTrue(names.isEmpty());
    }
    @Test
    public void should_iterate_over_bikes_repository(){
        BikeRepository repo = new BikeRepository();
        repo.add("Julien");
        repo.add("Mike");

        Iterator<String> iterator = repo.getIterator();

        List<String> names = new ArrayList<>();
        while(iterator.hasNext()){
            String name = iterator.next();
            names.add(name);
        }

        Assert.assertTrue(names.containsAll(Arrays.asList("Julien", "Mike")));
    }
}
