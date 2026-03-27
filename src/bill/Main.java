package bill;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----------- Welcome to Pizzamania -----------");
        System.out.println("1. Veg Pizza (300)");
        System.out.println("2. Non-Veg Pizza (400)");
        System.out.println("3. Delux Veg Pizza (550)");
        System.out.println("4. Delux Non-Veg Pizza (650)");
        System.out.print("Select Pizza: ");

        int choice = sc.nextInt();

        Pizza pizza;

        switch (choice) {

            case 1:
                pizza = new Pizza(true);
                break;

            case 2:
                pizza = new Pizza(false);
                break;

            case 3:
                pizza = new DeluxPizza(true);
                break;

            case 4:
                pizza = new DeluxPizza(false);
                break;

            default:
                System.out.println("Invalid Choice!");
                return;
        }

        // Only for normal pizza
        if (!(pizza instanceof DeluxPizza)) {

            System.out.print("Want Extra Cheese (y/n)? ");
            char cheese = sc.next().charAt(0);

            if (cheese == 'y' || cheese == 'Y') {
                pizza.addExtraCheese();
            }

            System.out.print("Want Extra Toppings (y/n)? ");
            char topping = sc.next().charAt(0);

            if (topping == 'y' || topping == 'Y') {
                pizza.addExtraToppings();
            }
        }

        System.out.print("Want Take Away (y/n)? ");
        char take = sc.next().charAt(0);

        if (take == 'y' || take == 'Y') {
            pizza.takeAway();
        }

        pizza.getBill();

        System.out.println("\nThank you!!! Visit Again 😊");

        sc.close();
    }
}