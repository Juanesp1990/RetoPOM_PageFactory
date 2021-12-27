package co.com.sofka.util;

public enum LimitTimeWait {
    ONE_SECONDS(1),
    FIVE_SECONDS(5),
    TEN_SECONDS(10);

    private final int value;

    public int getValue () {
        return value;
    }

    LimitTimeWait (int value) {
        this.value = value;
    }
}
