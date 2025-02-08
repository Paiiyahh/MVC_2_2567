import java.util.Date;

public class FreshFood extends Food {
    
    public FreshFood(String foodID, String expirationDate) {
        super(foodID, "Fresh", expirationDate);
    }

    @Override
    public String getExpirationStatus() {
        System.out.println(new Date());
        System.out.println(expirationDate);
        return new Date().after(expirationDate) ? "Expired" : "Not Expired";
    }
}
