package com.hyperclock.prashant.tourapplication;

//this class is used only used in Landmark fragment
public class Landmark {
    private double lat;
    private double lon;
    private String name;
    private String desc;
    private int imageId;

    public Landmark(double lat, double lon, String name, String desc, int imageId) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.desc = desc;
        this.imageId = imageId;
    }

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public int getImageId() {
        return imageId;
    }

}
