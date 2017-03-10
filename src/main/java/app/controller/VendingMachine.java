package app.controller;


import app.model.Coin;
import app.model.beverage.Beverage;
import app.model.beverage.BeverageType;
import app.util.Tuple;

import java.util.List;

public interface VendingMachine {
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
    List<Coin> cancelOrder();

    /**
     * This method confirms and executes order.
     *
     * @return A tuple containing beverage as it's first element,
     *         and a list of spare change.
     */
    Tuple<Beverage, List<Coin>> confirmOrder();
}
