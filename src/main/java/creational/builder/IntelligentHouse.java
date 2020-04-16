package creational.builder;

public class IntelligentHouse {
    private String room;
    private String door;

    public IntelligentHouse(String room) {
        this.room = room;
    }

    //Well, here we can not create another constructor of the same parameter type!
    /*
    public IntelligentHouse(String door) {
        this.door = door;
    }
     */

    public IntelligentHouse(String room, String door) {
        this.room = room;
        this.door = door;
    }

    public String getRoom() {
        return room;
    }

    public String getDoor() {
        return door;
    }
}
