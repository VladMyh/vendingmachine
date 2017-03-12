package app.controller;

import app.model.Coin;

import java.util.List;

public interface CoinManager {

    /**
     * This method calculates the change, that needs to be returned after the purchase.
     *
     * @param total Total amount given by the customer.
     * @param price The price of the product.
     * @return      A list of coins.
     */
    List<Coin> getRemainder(Integer total, Integer price);
}
