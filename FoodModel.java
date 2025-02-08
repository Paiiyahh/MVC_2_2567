import java.io.*;
import java.util.*;

public class FoodModel {
    private String csvFile = "food_data.csv";

    public List<Food> readFoodData() {
        List<Food> foodList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); // ข้าม header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) { // ตรวจสอบว่าข้อมูลครบ
                    String foodID = data[0].trim();
                    String foodType = data[1].trim();
                    String expirationDate = data[2].trim();

                    Food food = null;
                    switch (foodType) {
                        case "Fresh": food = new FreshFood(foodID, expirationDate); break;
                        case "Pickled": food = new PickledFood(foodID, expirationDate); break;
                        case "Canned": food = new CannedFood(foodID, expirationDate); break;
                    }
                    if (food != null) {
                        foodList.add(food);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodList;
    }

    public Food findFoodByID(String foodID) {
        for (Food food : readFoodData()) {
            if (food.getFoodID().equals(foodID)) {
                return food;
            }
        }
        return null; // ไม่พบรหัสอาหาร
    }

    public boolean isFoodIDValid(String foodID) {
        return foodID.matches("[1-9][0-9]{5}");
    }
}
