package bill;

public class DeluxPizza extends Pizza {

    public DeluxPizza(boolean veg) {
        super(veg);

        // Deluxe pizza already has everything
        super.addExtraCheese();
        super.addExtraToppings();
    }
}