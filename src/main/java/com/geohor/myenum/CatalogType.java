package com.geohor.myenum;

public enum CatalogType {

    ROADS("Drogi"),
    PIPES("Uzbrojenia"),
    BRIDGES("Mosty");

    private final String title;

    CatalogType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
