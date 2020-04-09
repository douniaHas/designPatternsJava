package creational;

import creational.builder.Meal;
import creational.builder.MealBean;
import creational.builder.MealTelescopicCreation;
import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

    @Test
    public void StringBuilderIsABuilder(){
        Assert.assertNotNull(new StringBuilder("First thing").append(" to say ")
                .append("is that it is a builder ")
                .append(". 42").toString());
    }

    @Test
    public void MealBeanIsTooPermissive(){
        MealBean mealBean = new MealBean();
        mealBean.setMeat("chicken");

        Assert.assertNull(mealBean.getVegetables());
    }

    @Test
    public void MealTelescopicCreationIsNotGoodEnough(){
        MealTelescopicCreation meal = new MealTelescopicCreation("meal");

        Assert.assertNotNull(meal.getVegetables());
    }

    @Test
    public void MealBuilderRocks(){
        Meal meal = new Meal.Builder().meat("turquey").build();
        Assert.assertEquals("turquey", meal.getMeat());
    }


}
