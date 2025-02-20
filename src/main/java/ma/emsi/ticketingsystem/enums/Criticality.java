package ma.emsi.ticketingsystem.enums;

import lombok.Getter;

@Getter
public enum Criticality {
    LOW("Basse"), MEDIUM("Modérée"), HIGH("Elevée");

    private final String displayName;

    private Criticality(String displayName) {
        this.displayName = displayName;
    }

}
