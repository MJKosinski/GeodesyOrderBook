package com.geohor.myenum;

public enum WorkType {

    MEASURMENT("Inwentaryzacja"),
    STEAKOUT("Tyczenie"),
    CALCULATION("Obliczenie");

    private final String title;

    WorkType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
