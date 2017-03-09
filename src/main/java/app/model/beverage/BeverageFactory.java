package app.model.beverage;

/**
 * Beverage factory to construct beverages.
 */
public class BeverageFactory {

    public Beverage makeBeverage(BeverageType type) {
        Beverage beverage = null;

        switch (type) {
            case Coffee:
                beverage = new Coffee();
                break;
            case Tea:
                beverage = new Tea();
                break;
            case Juice:
                beverage = new Juice();
                break;
        }

        return beverage;
    }
}
