package co.com.sofka.util;

public enum City {

        SABANETA_ANT("Sabaneta"),
        SOPO_CUN("Sopo"),
        BRUSELAS_HUI("Bruselas"),
        RIOSUCIO_CAL("Riosucio"),
        IBAGUE_TOL("Tolima");

        private final String value;

        public String getValue () {
            return value;
        }

    City (String value) {
            this.value = value;
        }

}
