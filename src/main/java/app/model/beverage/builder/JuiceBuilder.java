package app.model.beverage.builder;

import app.model.beverage.Juice;

/**
 * Builder for Juice class.
 */
public class JuiceBuilder {

    private Integer price;

    public JuiceBuilder price(Integer price) {
        this.price = price;
        return this;
    }

    public Juice build() {
        return new Juice(price);
    }
}
