package ru.stanislave.astoncourse.models;

public class Customer {
    private final int id;
    private final String name;

    public Customer() {
        this(0, "");
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
