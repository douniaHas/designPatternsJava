package creational.builder;

public class MealTelescopicCreation {
    private String vegetables;
    private String meat;
    private String desert;
    private String drink;

    public MealTelescopicCreation(String vegetables) {
        this.vegetables = vegetables;
    }

    public MealTelescopicCreation(String vegetables, String meat) {
        this.vegetables = vegetables;
        this.meat = meat;
    }

    public MealTelescopicCreation(String vegetables, String meat, String desert) {
        this.vegetables = vegetables;
        this.meat = meat;
        this.desert = desert;
    }

    public String getVegetables() {
        return vegetables;
    }

    public String getMeat() {
        return meat;
    }

    public String getDesert() {
        return desert;
    }

    public String getDrink() {
        return drink;
    }
}
