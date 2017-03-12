package app.model;

/**
 * Abstract class to represent a beverage
 */
public abstract class Beverage {
    private Integer price;

    public Beverage(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
