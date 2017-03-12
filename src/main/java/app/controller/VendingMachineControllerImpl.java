package app.controller;

import app.model.Coin;
import app.model.Beverage;
import app.model.BeverageFactory;
import app.model.BeverageType;
import app.util.Tuple;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VendingMachineControllerImpl implements VendingMachineController {

    private BeverageFactory beverageFactory;

    private CoinManager coinManager;

    private List<Coin> currentOrderChange;

    private BeverageType selectedBeverageType;

    public VendingMachineControllerImpl(BeverageFactory beverageFactory,
                                        CoinManager coinManager) {
        this.beverageFactory = beverageFactory;
        this.coinManager = coinManager;

        this.currentOrderChange = new LinkedList<>();
    }

    @Override
    public void putChange(Coin change) {
        currentOrderChange.add(change);
    }

    @Override
    public void selectBeverageType(BeverageType type) {
        selectedBeverageType = type;
    }

    public void cancelOrder() {
        clear();
    }

    @Override
    public List<Coin> returnChange() {
        return currentOrderChange;
    }

    @Override
    public Tuple<Beverage, List<Coin>> confirmOrder() {
        if(!currentOrderChange.isEmpty() && selectedBeverageType != null) {
            Optional<Integer> total = checkPrice(selectedBeverageType, currentOrderChange);

            if(total.isPresent()) {
                Beverage beverage = beverageFactory.makeBeverage(selectedBeverageType);

                List<Coin> remainder = coinManager.getRemainder(total.get(),
                        selectedBeverageType.getPrice());

                clear();

                return new Tuple<>(beverage, remainder);
            }
        }

        return null;
    }

    @Override
    public Integer currentTotal() {
        return currentOrderChange
                .stream()
                .mapToInt(Coin::getValue)
                .sum();
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
