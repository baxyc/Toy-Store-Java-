package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private final List<Toy> toys;

    public List<Toy> getToys() {
        return toys;
    }

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void play(List<Toy> prizeToys) {
        // Логика розыгрыша игрушек
    }


    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeToyWeight(int id, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void changeFrequency(int id, int newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }

    public Toy choosePrizeToy() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        int randomNumber = new Random().nextInt(totalWeight) + 1;
        int cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight) {
                toy.decreaseQuantity();
                return toy;
            }
        }
        return null;
    }

    public void savePrizeToyToFile(Toy toy, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(toy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addToy(new Toy(1, "Lego", 10, 30));
        toyShop.addToy(new Toy(2, "Barbie", 5, 20));
        toyShop.addToy(new Toy(3, "Teddy bear", 8, 25));
        toyShop.addToy(new Toy(4, "Action figure", 7, 15));
        toyShop.addToy(new Toy(5, "Hot Wheels", 6, 10));

        // change weight of toy with id 1 to 40%
        toyShop.changeToyWeight(1, 40);

        // change frequency of toy with id 3 to 50%
        toyShop.changeFrequency(3, 50);

        // choose a prize toy and save it to file "prize_toy.dat"
        Toy prizeToy = toyShop.choosePrizeToy();
        if (prizeToy != null) {
            toyShop.savePrizeToyToFile(prizeToy, "prize_toy.dat");
        } else {
            System.out.println("No toys available to choose as prize.");
        }
    }
}
