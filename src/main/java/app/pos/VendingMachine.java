package app.pos;

import app.model.Coin;
import app.model.beverage.*;
import app.util.Tuple;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private Map<Coin, Integer> change;

    private List<Coin> currentOrderChange;

    private BeverageType selectedBeverageType;

    private BeverageFactory beverageFactory;

    public VendingMachine(BeverageFactory beverageFactory) {
        this.beverageFactory = beverageFactory;

        initChange();
        this.currentOrderChange = new LinkedList<>();
    }

    private void initChange() {
        change = new HashMap<Coin, Integer>();
        change.put(Coin.One, 100);
        change.put(Coin.Five, 100);
        change.put(Coin.Ten, 100);
        change.put(Coin.TwntyFive, 100);
        change.put(Coin.Fifty, 100);
    }

    public void putChange(Coin change) {
        currentOrderChange.add(change);
    }

    public void selectBeverage(BeverageType type) {
        selectedBeverageType = type;
    }

    public Tuple<Beverage, List<Coin>> processOrder() {
        if(checkPrice(selectedBeverageType, currentOrderChange)) {
            Beverage beverage = beverageFactory.makeBeverage(selectedBeverageType);


        }

        return null;
    }

    private boolean checkPrice(BeverageType type, List<Coin> change) {
        boolean result = false;
        Integer total = change
                .stream()
                .mapToInt(Coin::getValue)
                .sum();

        switch (type) {
            case Coffee:
                result = total >= Coffee.COFFEE_PRICE;
                break;
            case Tea:
                result = total >= Tea.TEA_PRICE;
                break;
            case Juice:
                result = total >= Juice.JUICE_PRICE;
                break;
        }

        return result;
    }

    public List<Coin> cancelOrder() {
        //TODO: return change
        return null;
    }
}
