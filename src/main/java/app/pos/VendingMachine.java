package app.pos;

import app.model.Coin;
import app.model.beverage.Beverage;
import app.model.beverage.BeverageFactory;
import app.model.beverage.BeverageType;
import app.util.Tuple;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VendingMachine {

    private List<Coin> currentOrderChange;

    private BeverageType selectedBeverageType;

    private BeverageFactory beverageFactory;

    private CoinManager coinManager;

    public VendingMachine(BeverageFactory beverageFactory,
                          CoinManager coinManager) {
        this.beverageFactory = beverageFactory;
        this.coinManager = coinManager;

        this.currentOrderChange = new LinkedList<>();
    }

    public void putChange(Coin change) {
        currentOrderChange.add(change);
    }

    public void selectBeverage(BeverageType type) {
        selectedBeverageType = type;
    }

    public Tuple<Beverage, List<Coin>> processOrder() {
        Optional<Integer> total = checkPrice(selectedBeverageType, currentOrderChange);

        if(total.isPresent()) {
            Beverage beverage = beverageFactory.makeBeverage(selectedBeverageType);

            List<Coin> remainder = coinManager.getChangeRemainder(total.get(),
                    selectedBeverageType.getPrice());

            return new Tuple<>(beverage, remainder);
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

    public List<Coin> cancelOrder() {
        //TODO: return change
        return null;
    }
}
