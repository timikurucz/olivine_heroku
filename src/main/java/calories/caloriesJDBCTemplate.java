package calories;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class caloriesJDBCTemplate {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public DataBase listMeals() {
        DataBase allMeals = new DataBase();
        String SQL = "select * from meals";
        List<Meal> meals = jdbcTemplateObject.query(SQL,
            new MealMapper());
        for (Meal meal : meals) {
            allMeals.addMeal(meal);
        }
        return allMeals;
    }

    public Meal getMeal(Integer id) {
        String SQL = "select * from meals where id = ?";
        Meal meal = jdbcTemplateObject.queryForObject(SQL,
            new Object[]{id}, new MealMapper());
        return meal;
    }

    public DataBase filterMeals(String date) {
        DataBase allMeals = new DataBase();
        String SQL = "select * from meals where date = ?";
        List<Meal> meals = jdbcTemplateObject.query(SQL, new Object[]{date}, new MealMapper());
        for (Meal meal : meals) {
            allMeals.addMeal(meal);
        }
        return allMeals;
    }

    public void addMeal(String name, Integer calories, String date) {
        String SQL = "insert into meals (name, calories, date) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, name, calories, date);
    }

    public void deleteMeals(ItemIds ids) {
            StringBuilder idsStringified = new StringBuilder();
            for (Integer id : ids.item_ids) {
                if (idsStringified.length() == 0){
                    idsStringified.append(id);
                } else {
                    idsStringified.append(", ");
                    idsStringified.append(id);
                }
            }
            String SQL = "delete from meals where id IN (" + idsStringified.toString() + ")";
            System.out.println(idsStringified.toString());
            System.out.println(SQL);
            jdbcTemplateObject.update(SQL);
        }
    }






