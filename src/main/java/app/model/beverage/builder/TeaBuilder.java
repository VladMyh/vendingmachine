package app.model.beverage.builder;

import app.model.beverage.Tea;

/**
 * Builder for Tea class.
 */
public class TeaBuilder {

    private Integer price;

    public TeaBuilder price(Integer price) {
        this.price = price;
        return this;
    }

    public Tea build() {
        return new Tea(price);
    }
}
