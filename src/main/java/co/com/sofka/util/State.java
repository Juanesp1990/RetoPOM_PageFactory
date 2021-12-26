package co.com.sofka.util;


public enum State {
    ANTIOQUIA("Antioquia"),
    CUNDINAMARCA("Cundinamarca"),
    HUILA("Huila"),
    CALDAS("Caldas"),
    TOLIMA("Tolima");

    private final String value;

    public String getValue () {
        return value;
    }

    State (String value) {
        this.value = value;
    }
}
