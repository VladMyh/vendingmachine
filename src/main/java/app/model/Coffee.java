package app.model;

public class Coffee extends Beverage {

    public Coffee(Integer price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Coffee";
    }
}
