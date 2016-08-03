package calories;

import java.util.ArrayList;

public class DataBase {

    public ArrayList<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }


}
