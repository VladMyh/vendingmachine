package app.model;

/**
 * This enum represents values of coins accepted by the vending machine
 */
public enum Coin {
    Fifty(50),
    TwentyFive(25),
    Ten(10),
    Five(5),
    One(1);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
