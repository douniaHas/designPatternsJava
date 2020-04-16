package creational.builder;


public class Appartment {

    private final String room;
    private final String window;
    private final String door;

    public Appartment(Builder builder) {
        this.room = builder.room;
        this.window = builder.window;
        this.door = builder.door;
    }

    public static class Builder {
        private String room;
        private String door;
        private String window;

        public Builder room(String room) {
            this.room = room;
            return this;
        }

        public Builder door(String door) {
            this.door = door;
            return this;
        }

        public Builder window(String window) {
            this.window = window;
            return this;
        }

        public Appartment build() {
            return new Appartment(this);
        }
    }

    public String getRoom() {
        return room;
    }

    public String getWindow() {
        return window;
    }

    public String getDoor() {
        return door;
    }
}
