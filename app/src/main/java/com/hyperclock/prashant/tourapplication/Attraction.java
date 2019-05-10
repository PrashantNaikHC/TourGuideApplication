package com.hyperclock.prashant.tourapplication;

//this is the common class used for Temples, Hotels and Attractions
public class Attraction {
    private String name;
    private String description;
    private double lattitude;
    private double longitude;

    public Attraction(String name, String description, double lattitude, double longitude) {
        this.name = name;
        this.description = description;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
