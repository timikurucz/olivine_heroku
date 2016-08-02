package hello;

public class Response {
    public String status;
    public MealResponse meal;

    public Response(String status, Integer id) {
        this.status = status;
        this.meal = new MealResponse(id);
    }
}
