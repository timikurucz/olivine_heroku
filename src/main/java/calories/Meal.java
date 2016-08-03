package calories;

public class Meal {
    public int id;
    public String name;
    public int calories;
    public String date;

    public Meal(int id, String name, int calories, String date) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.date = date;
    }

    public Meal() {
    }

    public Meal(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id = " + this.id + ", name = " + this.name + ", calories = " + calories + " Date: " + date;
    }
}