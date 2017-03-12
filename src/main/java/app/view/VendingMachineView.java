package app.view;

import app.controller.VendingMachineController;
import app.model.Beverage;
import app.model.BeverageType;
import app.model.Coin;
import app.util.Tuple;

import java.util.LinkedHashMap;
import java.util.List;

public class VendingMachineView {

    VendingMachineController vendingMachineController;

    public VendingMachineView(VendingMachineController vendingMachineController) {
        this.vendingMachineController = vendingMachineController;
    }

    public String getBeverageTypes() {
        StringBuilder sb = new StringBuilder();

        for(BeverageType bt : BeverageType.values()) {
            sb.append(bt.ordinal())
              .append(".")
              .append(bt.toString())
              .append(": ")
              .append(bt.getPrice())
              .append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    public String getAcceptedCoins() {
        StringBuilder sb = new StringBuilder();

        for(Coin c : Coin.values()) {
            sb.append(c.ordinal())
              .append(".")
              .append(c.toString())
              .append(": ")
              .append(c.getValue())
              .append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    public String selectBeverageType(String number) {
        try {
            Integer id = Integer.parseInt(number);
            BeverageType type = BeverageType.values()[id];
            vendingMachineController.selectBeverageType(type);

            StringBuilder sb = new StringBuilder();
            sb.append("Selected: ")
              .append(type.toString())
              .append(System.getProperty("line.separator"));
            return sb.toString();
        }
        catch (IndexOutOfBoundsException | NumberFormatException ex) {
            return "Incorrect value, try again";
        }

    }

    public String cancelOrder() {
        List<Coin> coins = vendingMachineController.returnChange();

        StringBuilder sb = new StringBuilder();
        sb.append("Order canceled, your change: ")
          .append(coins)
          .append(System.getProperty("line.separator"));

        vendingMachineController.cancelOrder();

        return sb.toString();
    }

    public String putCoin(String number) {
        try {
            Integer id = Integer.parseInt(number);
            Coin coin = Coin.values()[id];
            vendingMachineController.putChange(coin);

            StringBuilder sb = new StringBuilder();
            sb.append("Current total: ")
              .append(vendingMachineController.currentTotal())
              .append(System.getProperty("line.separator"));
            return sb.toString();
        }
        catch (IndexOutOfBoundsException | NumberFormatException ex) {
            return "Incorrect value, try again";
        }
    }

    public String confirmOrder() {
        Tuple<Beverage, List<Coin>> result = vendingMachineController.confirmOrder();

        StringBuilder sb = new StringBuilder();
        sb.append("Your order: ")
          .append(result.getFirst())
          .append(",")
          .append(System.getProperty("line.separator"))
          .append("Your change: ")
          .append(result.getSecond());
        return sb.toString();
    }
}
