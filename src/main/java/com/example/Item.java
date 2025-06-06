package com.example;

public class Item {
    private String name;
    private double volume; // м3
    private double weight; // кг
    private double distance; // км
    private String warning;

    public Item(String name, double volume, double weight, double distance, String warning) {
        this.name = name;
        this.volume = volume;
        this.weight = weight;
        this.distance = distance;
        this.warning = warning;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    public String getWarning() {
        return warning;
    }
}
