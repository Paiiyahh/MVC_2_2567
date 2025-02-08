import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Constructor to initialize GUI components and set up event handling
public class FoodView extends JFrame {
    private JTextField foodIDField;
    private JLabel resultLabel;
    private FoodController controller;

    public FoodView(FoodController controller) {
        this.controller = controller;

        setTitle("Food Expiration Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
       // Add components to the window
        add(new JLabel("Enter Food ID:"));
        foodIDField = new JTextField(10);
        add(foodIDField);

        JButton checkButton = new JButton("Check Expiration");
        add(checkButton);

        resultLabel = new JLabel(" ");
        add(resultLabel);

        JButton reportButton = new JButton("Show Report");
        add(reportButton);

        // Action for the checkButton
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

        // Action for the reportButton
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String report = controller.generateReport();
                JOptionPane.showMessageDialog(FoodView.this, report, "Food Expiration Report", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);// Make the frame visible
    }

    // Main method to start the application
    public static void main(String[] args) {
        FoodModel model = new FoodModel(); // Create model to handle food data
        FoodController controller = new FoodController(model);
        new FoodView(controller);
    }
}
