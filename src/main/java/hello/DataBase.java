package hello;

import java.util.ArrayList;

public class DataBase {

    public ArrayList<Meal> meals = new ArrayList<Meal>();

    public void defaultMeal() {
        if (meals.size() == 0) {
            meals.add(new Meal(1, "gyros", 450, "2016-05-24"));
            meals.add(new Meal(2, "hamburger", 600, "2016-05-24"));
            meals.add(new Meal(3, "tic-tac", 2, "2016-05-24"));
        }
    }

    public void addMeal(Meal veryNew) {
        meals.add(veryNew);
    }

    public ItemIds deleteMeals(ItemIds idList) {
        ItemIds returnThisList = new ItemIds();
        for (int id : idList.item_ids) {
            if (deleteById(id)) {
                returnThisList.addItem(id);
            }
        }
        return returnThisList;
    }

    public String deleteMeal(Integer id) {
        if (deleteById(id)) {
            return "ok";
        } else {
            return "doesn't exist";
        }
    }

    private boolean deleteById(Integer id) {
        for (Meal meal : meals) {
            if (meal.id == id) {
                meals.remove(meal);
                return true;
            }
        }
        return false;
    }

    public Meal getMeal(int id) {
        for (Meal meal : meals) {
            if (meal.id == id) {
                return meal;
            }
        }
        return null;
    }

    public DataBase getFilteredMeals(String date) {
        DataBase filteredMeals = new DataBase();
        for (Meal meal : meals) {
            if (meal.date.equals(date)) {
                filteredMeals.addMeal(meal);
            }
        }
        return filteredMeals;
    }
}