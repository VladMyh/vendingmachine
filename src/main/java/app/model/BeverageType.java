package app.model;

/**
 * Enum to represent beverage type
 */
public enum BeverageType {
    Coffee(35),
    Tea(25),
    Juice(45);

    private Integer price;

    BeverageType(Integer price){
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
