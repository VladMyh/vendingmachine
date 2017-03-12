package app.controller;

import app.model.Coin;
import app.util.Tuple;

import java.util.LinkedList;
import java.util.List;

public class CoinManagerImpl implements CoinManager {

    public CoinManagerImpl() {}

    public List<Coin> getRemainder(Integer total, Integer price) {
        Integer remainder = total - price;
        List<Coin> result = new LinkedList<>();

        for (Coin c : Coin.values()) {
            Tuple<List<Coin>, Integer> res = checkNominal(c, remainder);
            result.addAll(res.getFirst());
            remainder = res.getSecond();

            if(remainder == 0) {
                break;
            }
        }

        return result;
    }

    /**
     * This method calculates what nominal of coins will be returned in change.
     *
     * First, the method checks if the remainder can be evenly divided, starting from
     * the highest coin nominal. It then returns the list of coins and zero remainder.
     *
     * Second, the method checks if any number of coins of the current nominal can be
     * returned, if so, it returns a list of coins and an updated remained.
     *
     * @param nominal   The coin nominal.
     * @param remainder The remained to be processed.
     * @return          A tuple where first element is a list of coins, and second is
     *                  an updated remainder.
     */
    private Tuple<List<Coin>, Integer> checkNominal(Coin nominal, Integer remainder) {
        List<Coin> coins = new LinkedList<>();

        Integer times = remainder / nominal.getValue();
        for (int i = 0; i < times; i++) {
            coins.add(nominal);
        }

        if (remainder % nominal.getValue() == 0) {
            remainder = 0;
        }
        else if ((double)remainder / (double) nominal.getValue() > 1) {
            remainder -= times * nominal.getValue();
        }

        return new Tuple<>(coins, remainder);
    }
}
