package app.model.beverage.builder;

import app.model.beverage.Tea;

/**
 * Builder for Tea class.
 */
public class TeaBuilder {

    private Float price;

    public TeaBuilder price(Float price) {
        this.price = price;
        return this;
    }

    public Tea build() {
        return new Tea(price);
    }
}
