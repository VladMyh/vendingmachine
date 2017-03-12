package app.model;

public class Tea extends Beverage {

    public Tea(Integer price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Tea";
    }
}
