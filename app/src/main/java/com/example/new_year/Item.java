package com.example.new_year;

public class Item {

    String name ;
    int image;
    int data;
    long countdown;

    public Item(String name, int image, int data , long countdown) {
        this.name = name;
        this.image = image;
        this.data = data;
        this.countdown = countdown;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getData() {
        return data;
    }

    public long getCountdown() { return countdown; }
}
