package app.model.beverage;

/**
 * Abstract class to represent a beverage
 */
public abstract class Beverage {
    private Float price;

    public Beverage(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
