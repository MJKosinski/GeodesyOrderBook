package com.geohor.myenum;

public enum StatusType {

    EXPECTANT("przyjęte"),
    IN_PROGRESS("w opracowaniu"),
    REJECTED("odrzucone"),
    COMPLETED("zakończone");

    private final String title;

    StatusType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
