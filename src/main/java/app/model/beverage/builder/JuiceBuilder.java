package app.model.beverage.builder;

import app.model.beverage.Juice;

/**
 * Builder for Juice class.
 */
public class JuiceBuilder {

    private Float price;

    public JuiceBuilder price(Float price) {
        this.price = price;
        return this;
    }

    public Juice build() {
        return new Juice(price);
    }
}
