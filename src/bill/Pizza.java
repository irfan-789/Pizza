package bill;

public class Pizza {

    private int price;
    private boolean veg;

    private int extraCheesePrice = 100;
    private int extraToppingsPrice = 150;
    private int packagingCharges = 20;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isTakeAway = false;

    public Pizza(boolean veg) {
        this.veg = veg;

        if (veg) {
            price = 300;
        } else {
            price = 400;
        }
    }

    public void addExtraCheese() {
        isExtraCheeseAdded = true;
        price += extraCheesePrice;
    }

    public void addExtraToppings() {
        isExtraToppingsAdded = true;
        price += extraToppingsPrice;
    }

    public void takeAway() {
        isTakeAway = true;
        price += packagingCharges;
    }

    public void getBill() {

        System.out.println("\n----- BILL -----");

        if (veg) {
            System.out.println("Pizza: Veg (300)");
        } else {
            System.out.println("Pizza: Non-Veg (400)");
        }

        if (isExtraCheeseAdded) {
            System.out.println("Extra Cheese: " + extraCheesePrice);
        }

        if (isExtraToppingsAdded) {
            System.out.println("Extra Toppings: " + extraToppingsPrice);
        }

        if (isTakeAway) {
            System.out.println("Take Away: " + packagingCharges);
        }

        System.out.println("-------------------");
        System.out.println("Total Amount: " + price);
        System.out.println("-------------------");
    }
}