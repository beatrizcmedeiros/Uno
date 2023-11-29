package com.tsi.uno;

public class ListItem {
    private int imageResourceId;
    private String description;

    public ListItem(int imageResourceId, String description) {
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }
}