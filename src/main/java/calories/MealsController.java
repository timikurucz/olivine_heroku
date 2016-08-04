package calories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealsController {

    public DriverManagerDataSource getDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        String energy = System.getenv().get("Passw");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setPassword(energy);
        dataSource.setUrl("jdbc:mysql://b540da1bff825c:4cf3a5c3@eu-cdbr-west-01.cleardb.com/heroku_8414b8f4e2fbcbe?reconnect=true");
//        dataSource.setUsername("root");
        return dataSource;
    }

    //Get all meals
    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public DataBase meals(@RequestParam(value = "date", defaultValue = "all") String date) {
        caloriesJDBCTemplate newTemplate = new caloriesJDBCTemplate();
        newTemplate.setDataSource(getDatasource());
        if (date.equals("all")) {
            return newTemplate.listMeals();
        }  else {
            return newTemplate.filterMeals(date);
        }
    }

    //Get meal by ID
    @RequestMapping(value = "/meal/{id}", method = RequestMethod.GET)
    public Meal meal(@PathVariable("id") Integer id) {
        caloriesJDBCTemplate newTemplate = new caloriesJDBCTemplate();
        newTemplate.setDataSource(getDatasource());
        return newTemplate.getMeal(id);
    }

    //Add a new meal
    @RequestMapping(value = "/meals", method = RequestMethod.POST)
    public Meal addMeal(@RequestBody Meal addedMeal) {
        caloriesJDBCTemplate newTemplate = new caloriesJDBCTemplate();
        newTemplate.setDataSource(getDatasource());
        newTemplate.addMeal(addedMeal.id, addedMeal.name, addedMeal.calories, addedMeal.date);
        return addedMeal;
    }

    //Delete meal(s)
    @RequestMapping(value = "/meals", method = RequestMethod.DELETE)
    public ItemIds deleteMeals(@RequestBody ItemIds ids) {
        caloriesJDBCTemplate newTemplate = new caloriesJDBCTemplate();
        newTemplate.setDataSource(getDatasource());
        newTemplate.deleteMeals(ids);
        return ids;
    }
}
