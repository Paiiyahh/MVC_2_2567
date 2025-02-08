public class FoodController {
    private FoodModel model;

    public FoodController(FoodModel model) {
        this.model = model;
    }

    public boolean validateFoodID(String foodID) {
        return model.isFoodIDValid(foodID);
    }

    public String checkFoodExpiration(String foodID) {
        Food food = model.findFoodByID(foodID);
        if (food == null) {
            return "Food ID not found"; // หากไม่มีข้อมูล
        }
        return food.getExpirationStatus();
    }
}
