package com.example.estagiomobilefabiocavallari.model;

import java.io.Serializable;

public class Offer implements Serializable {

    private final String title;
    private final String image;
    private final String value;
    private final String description;

    public Offer(String title, String image, String value, String description) {
        this.title = title;
        this.image = image;
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
