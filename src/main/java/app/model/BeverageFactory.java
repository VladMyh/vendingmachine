package app.model;

/**
 * Beverage factory to construct beverages.
 */
public class BeverageFactory {

    public Beverage makeBeverage(BeverageType type) {
        Beverage beverage = null;

        switch (type) {
            case Coffee:
                beverage = new Coffee(BeverageType.Coffee.getPrice());
                break;
            case Tea:
                beverage = new Tea(BeverageType.Tea.getPrice());
                break;
            case Juice:
                beverage = new Juice(BeverageType.Juice.getPrice());
                break;
        }

        return beverage;
    }
}
