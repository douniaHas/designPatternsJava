package behavioral.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BikeRepository implements Iterable<String> {

    private List<String> bikes = new ArrayList<>();
    private int currentIndex = 0;

    public void add(String bike){
        bikes.add(bike);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex<bikes.size() && bikes.get(currentIndex)!=null;
            }

            @Override
            public String next() {
                return bikes.get(currentIndex++);
            }

        };
    }

    public Iterator<String> getIterator() {
        return iterator();
    }
}
