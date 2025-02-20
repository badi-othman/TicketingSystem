package ma.emsi.ticketingsystem.enums;

import lombok.Getter;

@Getter
public enum Products {
    SAGE50("Sage 50"), SAGE100("Sage 100"), SAGEX3("Sage X3");
    private final String displayName;

    Products(String displayName) {
        this.displayName = displayName;
    }
}
