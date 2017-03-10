package app.controller;

import app.model.Coin;
import app.util.Tuple;

import java.util.LinkedList;
import java.util.List;

public class CoinManager {

    public CoinManager() {}

    public List<Coin> getChangeRemainder(Integer total, Integer price) {
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
