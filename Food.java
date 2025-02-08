import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Food {
    protected String foodID;
    protected String foodType;
    protected Date expirationDate;

    public Food(String foodID, String foodType, String expirationDate) {
        this.foodID = foodID;
        this.foodType = foodType;
        try {
            this.expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(expirationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract String getExpirationStatus(); // ให้ subclass กำหนดเอง

    public String getFoodID() {
        return foodID;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getExpirationDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(expirationDate);
    }
}
