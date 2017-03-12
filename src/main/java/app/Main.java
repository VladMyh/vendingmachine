package app;

import app.controller.CoinManager;
import app.controller.CoinManagerImpl;
import app.controller.VendingMachineController;
import app.controller.VendingMachineControllerImpl;
import app.model.BeverageFactory;
import app.view.VendingMachineView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BeverageFactory beverageFactory = new BeverageFactory();
        CoinManager coinManager = new CoinManagerImpl();
        VendingMachineController vendingMachineController = new VendingMachineControllerImpl(beverageFactory, coinManager);
        VendingMachineView vendingMachineView = new VendingMachineView(vendingMachineController);

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Vending machine!");
        while (true) {
            System.out.println("1. Select beverage");
            System.out.println("2. Put change");
            System.out.println("3. Confirm order");
            System.out.println("4. Cancel order");

            if(sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Select beverage:");
                        System.out.println(vendingMachineView.getBeverageTypes());

                        System.out.println(vendingMachineView.selectBeverageType(sc.next()));
                        break;
                    case 2:
                        System.out.println("Put change:");
                        System.out.println(vendingMachineView.getAcceptedCoins());

                        System.out.println(vendingMachineView.putCoin(sc.next()));
                        break;
                    case 3:
                        System.out.println(vendingMachineView.confirmOrder());
                        break;
                    case 4:
                        System.out.println(vendingMachineView.cancelOrder());
                        break;
                    default:
                        System.out.println("Incorrect input, try again");
                }
            }
        }
    }
}
