package creational.factory;

public class WebsiteFactory {

    public Website create(Type type){
        switch (type) {
            case BLOG:
                return new BlogWebsite();
            case SHOP:
                return new ShopWebsite();
            default:
                return null;
        }
    }
}
