package org.example;

import java.io.Serializable;

public class Toy implements Serializable {
    private final int id;
    private final String name;
    private int quantity;
    private int weight;
    private int frequency;

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCount() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }
}
