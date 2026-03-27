package bill;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaGUIPro {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pizzamania Billing System");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel title = new JLabel("PIZZAMANIA BILLING", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        String[] pizzas = {
                "Veg Pizza (300)",
                "Non-Veg Pizza (400)",
                "Delux Veg Pizza (550)",
                "Delux Non-Veg Pizza (650)"
        };

        JComboBox<String> pizzaBox = new JComboBox<>(pizzas);

        JCheckBox cheese = new JCheckBox("Extra Cheese (100)");
        JCheckBox toppings = new JCheckBox("Extra Toppings (150)");
        JCheckBox takeaway = new JCheckBox("Take Away (20)");

        JButton billBtn = new JButton("Generate Bill");

        JTextArea result = new JTextArea();
        result.setEditable(false);
        result.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(result);

        // Disable options for Deluxe
        pizzaBox.addActionListener(e -> {
            int choice = pizzaBox.getSelectedIndex();
            boolean isDelux = (choice == 2 || choice == 3);

            cheese.setEnabled(!isDelux);
            toppings.setEnabled(!isDelux);

            if (isDelux) {
                cheese.setSelected(false);
                toppings.setSelected(false);
            }
        });

        // Button Action
        billBtn.addActionListener(e -> {

            int price = 0;
            String bill = "-------- BILL --------\n";

            int choice = pizzaBox.getSelectedIndex();

            switch (choice) {
                case 0:
                    price = 300;
                    bill += "Veg Pizza: 300\n";
                    break;
                case 1:
                    price = 400;
                    bill += "Non-Veg Pizza: 400\n";
                    break;
                case 2:
                    price = 550;
                    bill += "Delux Veg Pizza: 550\n";
                    break;
                case 3:
                    price = 650;
                    bill += "Delux Non-Veg Pizza: 650\n";
                    break;
            }

            boolean isDelux = (choice == 2 || choice == 3);

            if (!isDelux) {
                if (cheese.isSelected()) {
                    price += 100;
                    bill += "Extra Cheese: 100\n";
                }

                if (toppings.isSelected()) {
                    price += 150;
                    bill += "Extra Toppings: 150\n";
                }
            }

            if (takeaway.isSelected()) {
                price += 20;
                bill += "Take Away: 20\n";
            }

            bill += "----------------------\n";
            bill += "Total Amount: " + price + "\n";
            bill += "----------------------\n";
            bill += "Thank you! Visit Again 😊";

            result.setText(bill);
        });

        panel.add(title);
        panel.add(pizzaBox);
        panel.add(cheese);
        panel.add(toppings);
        panel.add(takeaway);
        panel.add(billBtn);
        panel.add(scroll);

        frame.add(panel);
        frame.setVisible(true);
    }
}

