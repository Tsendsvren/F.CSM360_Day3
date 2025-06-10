package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Item {
    private String name;
    private double volume; // м3
    private double weight; // кг
    private double distance; // км
    private String warning;
    private static final Logger logger = LogManager.getLogger(Item.class);

    public Item(String name, double volume, double weight, double distance, String warning) {
        if (name == null || name.trim().isEmpty()) {
            logger.error("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (volume < 0) {
            logger.error("Volume cannot be negative");
            throw new IllegalArgumentException("Volume cannot be negative");
        }
        if (weight < 0) {
            logger.error("Weight cannot be negative");
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        if (distance < 0) {
            logger.error("Distance cannot be negative");
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        if (warning == null) {
            warning = "";
        }

        this.name = name;
        this.volume = volume;
        this.weight = weight;
        this.distance = distance;
        this.warning = warning;

        logger.info("Шинэ Item үүсгэгдлээ: {}", name);
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
