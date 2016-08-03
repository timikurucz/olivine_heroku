package calories;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MealMapper implements RowMapper<Meal> {
    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Meal meal = new Meal();
        meal.id = rs.getInt("id");
        meal.name = rs.getString("name");
        meal.calories = rs.getInt("calories");
        meal.date = rs.getString("date");
        return meal;
    }
}
