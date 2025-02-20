package ma.emsi.ticketingsystem.enums;

import lombok.Getter;

@Getter
public enum Services {
    COMPTABILITE_GESTION("Comptabilité et gestion"), COMMERCE("Commerce"), PAIE_RH("Paie RH");

    private final String displayName;

    private Services(String displayName) {
        this.displayName = displayName;
    }
}
