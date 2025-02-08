import java.text.SimpleDateFormat;
import java.util.Date;

// Abstract Food class for defining basic properties of food items
public abstract class Food {
    protected String foodID; // Food identification
    protected String foodType; // Type of food (e.g., Canned, Fresh)
    protected Date expirationDate; // Expiration date of the food item

    // Constructor to initialize foodID, foodType, and expirationDate
    public Food(String foodID, String foodType, String expirationDate) {
        this.foodID = foodID;
        this.foodType = foodType;
        try {
            // Parse the expiration date from string to Date
            this.expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(expirationDate);
        } catch (Exception e) {
            e.printStackTrace(); // Print any parsing errors
        }
    }

    // Abstract method to be implemented by subclasses for checking expiration status
    public abstract String getExpirationStatus();

    // Getter for foodID
    public String getFoodID() {
        return foodID;
    }

    // Getter for foodType
    public String getFoodType() {
        return foodType;
    }

    // Getter for formatted expirationDate as a string
    public String getExpirationDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(expirationDate);
    }
}

