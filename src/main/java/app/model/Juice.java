package app.model;

public class Juice extends Beverage {

    public Juice(Integer price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Juice";
    }
}
