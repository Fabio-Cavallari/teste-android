package com.example.estagiomobilefabiocavallari.model;

public class Offer {
    private final String title;
    private final String image;
    private final float value;

    public Offer(String title, String image, float value) {
        this.title = title;
        this.image = image;
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
