package app.model;

/**
 * This enum represents values of coins accepted by the vending machine
 */
public enum Coin {
    One(1),
    Five(5),
    Ten(10),
    TwntyFive(25),
    Fifty(50);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
