package ma.emsi.ticketingsystem.enums;

import lombok.Getter;

@Getter
public enum Status {
    OPEN("Open"),IN_PROGRESS("In Progress"),CLOSED("Closed");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }
}
