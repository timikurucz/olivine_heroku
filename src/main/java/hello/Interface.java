package hello;

import java.util.ArrayList;
import java.util.Date;

public interface Interface {
    ArrayList<Meal> list = new ArrayList<Meal>();

    public void getMeals();
    public void addMeal(Meal m);
    public void deleteMeal(Meal m);
    public void filterMeals(Date d);


}
