import java.util.List;

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

    public String generateReport() {
        List<Food> foods = model.readFoodData();
        
        // Variables to store the counts
        int totalExpired = 0, totalNotExpired = 0;
        int totalFresh = 0, totalPickled = 0, totalCanned = 0;
        int expiredFresh = 0, expiredPickled = 0, expiredCanned = 0;

        // Loop through the foods and ++ 
        for (Food food : foods) {
            if (food.getExpirationStatus().equals("Expired")) {
                totalExpired++;
                if (food.getFoodType().equals("Fresh")) expiredFresh++;
                if (food.getFoodType().equals("Pickled")) expiredPickled++;
                if (food.getFoodType().equals("Canned")) expiredCanned++;
            } else {
                totalNotExpired++;
            }

            // Count types
            if (food.getFoodType().equals("Fresh")) totalFresh++;
            if (food.getFoodType().equals("Pickled")) totalPickled++;
            if (food.getFoodType().equals("Canned")) totalCanned++;
        }

        // Create the report string
        StringBuilder report = new StringBuilder();
        report.append("Food Expiration Report\n");
        report.append("Total Foods Inspected: ").append(foods.size()).append("\n");
        report.append("\nTotal Foods by Type:\n");
        report.append("Fresh: ").append(totalFresh).append("\n");
        report.append("Pickled: ").append(totalPickled).append("\n");
        report.append("Canned: ").append(totalCanned).append("\n");
        report.append("\nExpired Foods by Type:\n");
        report.append("Fresh: ").append(expiredFresh).append("\n");
        report.append("Pickled: ").append(expiredPickled).append("\n");
        report.append("Canned: ").append(expiredCanned).append("\n");
        report.append("\nTotal Expired Foods: ").append(totalExpired).append("\n");
        report.append("Total Not Expired Foods: ").append(totalNotExpired).append("\n");

        return report.toString();
    }
}
