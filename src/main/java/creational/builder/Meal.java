package creational.builder;

public class Meal {
    //immutable
    private final String vegetables;
    private final String meat;
    private final String desert;
    private final String drink;

    public Meal(Builder builder) {
        this.vegetables = builder.vegetables;
        this.meat = builder.meat;
        this.desert = builder.desert;
        this.drink = builder.drink;
    }

    public static class Builder{
        private String vegetables;
        private String meat;
        private String desert;
        private String drink;

        //modifies only one field at time and chain
        public Builder meat(String meat){
            this.meat = meat;
            return this;
        }

        public Builder vegetables(String vegetables){
            this.vegetables = vegetables;
            return this;
        }

        public Builder desert(String desert){
            this.desert = desert;
            return this;
        }

        public Builder drink(String drink){
            this.drink = drink;
            return this;
        }

        public Meal build(){
            return new Meal(this);
        }
    }

    //Getters only
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
