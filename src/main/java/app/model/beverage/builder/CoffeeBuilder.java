package app.model.beverage.builder;

import app.model.beverage.Coffee;

/**
 * Builder for Coffee class.
 */
public class CoffeeBuilder {

    private Float price;

    public CoffeeBuilder price(Float price) {
        this.price = price;
        return this;
    }

    public Coffee build() {
        return new Coffee(price);
    }
}
