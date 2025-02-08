import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodView extends JFrame {
    private JTextField foodIDField;
    private JLabel resultLabel;
    private FoodController controller;

    public FoodView(FoodController controller) {
        this.controller = controller;

        setTitle("Food Expiration Checker");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Food ID:"));
        foodIDField = new JTextField(10);
        add(foodIDField);

        JButton checkButton = new JButton("Check Expiration");
        add(checkButton);

        resultLabel = new JLabel(" ");
        add(resultLabel);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String foodID = foodIDField.getText().trim();
                if (controller.validateFoodID(foodID)) {
                    String result = controller.checkFoodExpiration(foodID);
                    resultLabel.setText(result);
                } else {
                    resultLabel.setText("Invalid Food ID");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        FoodModel model = new FoodModel();
        FoodController controller = new FoodController(model);
        new FoodView(controller);
    }
}
