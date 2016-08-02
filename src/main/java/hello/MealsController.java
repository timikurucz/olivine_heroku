package hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class MealsController {

    DataBase myFoods = new DataBase();

    @RequestMapping(value = "/meal/{id}", method = RequestMethod.GET)
    public Meal meal(@PathVariable("id") Integer id) {
        myFoods.defaultMeal();
        return myFoods.getMeal(id);
    }

    @RequestMapping(value = "/meal", method = RequestMethod.GET)
    public Meal meal2(@RequestParam(value = "id") Integer id) {
        myFoods.defaultMeal();
        return myFoods.getMeal(id);
    }

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public DataBase meals(@RequestParam(value = "date", defaultValue = "all") String date) {
        myFoods.defaultMeal();
        if (date.equals("all")) {
            return myFoods;
        }  else {
            return myFoods.getFilteredMeals(date);
        }
    }

    @RequestMapping(value = "/meals", method = RequestMethod.POST)
    public Meal addMeal(@RequestBody Meal addedMeal) {
        myFoods.addMeal(addedMeal);
        return addedMeal;
    }
    // tobb elem torlese:
    @RequestMapping(value = "/meals", method = RequestMethod.DELETE)
    public ItemIds deleteMeals(@RequestBody ItemIds ids) {
        return myFoods.deleteMeals(ids);
    }

    //egy elem torlese:
    @RequestMapping(value = "/meals/{id}", method = RequestMethod.DELETE)
    public Response deleteMeal(@PathVariable ("id") Integer id) {
        return new Response(myFoods.deleteMeal(id), id);
    }

}
