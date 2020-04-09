package creational.factory;

import java.util.Arrays;

public class BlogWebsite extends Website {

    public BlogWebsite(){
        getPages().addAll(Arrays.asList("contact", "page1"));
    }
}
