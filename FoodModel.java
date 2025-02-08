import java.io.*;
import java.util.*;

// FoodModel class handles reading food data from a CSV file and performing operations on food objects
public class FoodModel {
    private String csvFile = "food_data.csv"; // Path to the CSV file containing food data

    // Method to read food data from the CSV file and return a list of Food objects
    public List<Food> readFoodData() {
        List<Food> foodList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); // Skip header row
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split data by commas
                if (data.length == 3) { // Check if the row has the correct number of columns
                    String foodID = data[0].trim();
                    String foodType = data[1].trim();
                    String expirationDate = data[2].trim();

                    // Create appropriate Food object based on foodType
                    Food food = null;
                    switch (foodType) {
                        case "Fresh": food = new FreshFood(foodID, expirationDate); break;
                        case "Pickled": food = new PickledFood(foodID, expirationDate); break;
                        case "Canned": food = new CannedFood(foodID, expirationDate); break;
                    }
                    // Add food object to the list if it's valid
                    if (food != null) {
                        foodList.add(food);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print error if reading fails
        }
        return foodList;
    }

    // Method to find a Food object by its foodID
    public Food findFoodByID(String foodID) {
        for (Food food : readFoodData()) {
            if (food.getFoodID().equals(foodID)) {
                return food; // Return the food object if found
            }
        }
        return null; // Return null if foodID is not found
    }

    // Method to validate foodID format (6 digits starting with a non-zero digit)
    public boolean isFoodIDValid(String foodID) {
        return foodID.matches("[1-9][0-9]{5}");
    }
}
