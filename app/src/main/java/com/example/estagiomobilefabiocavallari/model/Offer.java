package com.example.estagiomobilefabiocavallari.model;

public class Offer {

    private final String title;
    private final String image;
    private final String value;

    public Offer(String title, String image, String value) {
        this.title = title;
        this.image = image;
        this.value = value;
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
}
