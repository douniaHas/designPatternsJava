package creational;

import creational.builder.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The builder builds objects having a lot of parameters, avoiding the cost of telescopic construction.
 * Fields can be immutable witch is a great gain
 * The builder is static so that we can access it directly
 */
public class BuilderTest {

    @Test
    public void should_build_a_string(){
        Assert.assertNotNull(new StringBuilder("First thing").append(" to say ")
                .append("is that it is a builder ")
                .append(".").toString());
    }

    /**
     * Step 1 : Too permissive ; we have access to all our fields through setters. There is no contract.
     */
    @Test
    public void should_build_a_house_with_a_door(){
        House house = new House();
        house.setDoor("Kitchen's door");

        assertEquals("Kitchen's door", house.getDoor());
        assertNull(house.getRoom());
    }

    /**
     * Step 2 : Not good enough ! Imagine that you want to have more combinations with a lot of arguments, it starts to be messy
     */
    @Test
    public void should_build_a_house_with_a_door_and_a_room(){
        IntelligentHouse house = new IntelligentHouse("Julie's room", "Main door");
        assertEquals("Julie's room", house.getRoom());
    }

    /**
     * Step 3 : The creation is free and we have control over it. We don't have access directly to the object build
     */
    @Test
    public void should_build_a_house_with_all_needed_easily(){
        Appartment.Builder appartmentBuilder = new Appartment.Builder();
        Appartment appartment =  appartmentBuilder.room("Julie's room")
                .door("Main door")
                .window("Julie's room window")
                .build();

        assertEquals("Julie's room window", appartment.getWindow());
        assertEquals("Julie's room", appartment.getRoom());
        assertEquals("Main door", appartment.getDoor());
    }

}
