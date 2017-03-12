package app.controller;


import app.model.Coin;
import app.model.Beverage;
import app.model.BeverageType;
import app.util.Tuple;

import java.util.List;

public interface VendingMachineController {
    /**
     * This method adds a coin into vending machine.
     *
     * @param coin A coin to add.
     */
    void putChange(Coin coin);

    /**
     * This method is used to select a beverage type.
     *
     * @param type Selected beverage type.
     */
    void selectBeverageType(BeverageType type);

    /**
     * This method is used to cancel order.
     *
     * @return List of coins.
     */
    void cancelOrder();

    /**
     * This method returns current change.
     *
     * @return A list of change.
     */
    List<Coin> returnChange();

    /**
     * This method confirms and executes order.
     *
     * @return A tuple containing beverage as it's first element,
     *         and a list of spare change.
     */
    Tuple<Beverage, List<Coin>> confirmOrder();

    /**
     * This method returns current total value of coins.
     *
     * @return Total value of coins.
     */
    Integer currentTotal();
}
