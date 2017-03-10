package app.controller;

import app.model.Coin;
import app.model.beverage.Beverage;
import app.model.beverage.BeverageFactory;
import app.model.beverage.BeverageType;
import app.util.Tuple;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VendingMachineController implements VendingMachine {

    private BeverageFactory beverageFactory;

    private CoinManager coinManager;

    private List<Coin> currentOrderChange;

    private BeverageType selectedBeverageType;

    public VendingMachineController(BeverageFactory beverageFactory,
                                    CoinManager coinManager) {
        this.beverageFactory = beverageFactory;
        this.coinManager = coinManager;

        this.currentOrderChange = new LinkedList<>();
    }

    public void putChange(Coin change) {
        currentOrderChange.add(change);
    }

    public void selectBeverageType(BeverageType type) {
        selectedBeverageType = type;
    }

    public List<Coin> cancelOrder() {
        List<Coin> result = currentOrderChange;

        clear();

        return result;
    }

    public Tuple<Beverage, List<Coin>> confirmOrder() {
        if(!currentOrderChange.isEmpty() && selectedBeverageType != null) {
            Optional<Integer> total = checkPrice(selectedBeverageType, currentOrderChange);

            if(total.isPresent()) {
                Beverage beverage = beverageFactory.makeBeverage(selectedBeverageType);

                List<Coin> remainder = coinManager.getChangeRemainder(total.get(),
                        selectedBeverageType.getPrice());

                clear();

                return new Tuple<>(beverage, remainder);
            }
        }

        return null;
    }

    private Optional<Integer> checkPrice(BeverageType type, List<Coin> change) {
        Integer total = change
                .stream()
                .mapToInt(Coin::getValue)
                .sum();

        if(total >= type.getPrice()) {
            return Optional.of(total);
        }

        return Optional.empty();
    }

    private void clear() {
        currentOrderChange.clear();
        selectedBeverageType = null;
    }
}
