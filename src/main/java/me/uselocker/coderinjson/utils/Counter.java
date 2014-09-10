package me.uselocker.coderinjson.utils;

public final class Counter {
    private int counter = -1;

    public int inc() {
        ++counter;
        return counter;
    }

    public int dec() {
        --counter;
        return counter;
    }
}
