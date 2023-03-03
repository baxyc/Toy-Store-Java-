package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToyShop {



    private ToyShop toyShop;

    @BeforeEach
    public void setUp() {
        toyShop = new ToyShop();
        // Добавляем игрушки в магазин
        toyShop.addToy(new Toy(1, "Кукла", 5, 50));
        toyShop.addToy(new Toy(2, "Мяч", 10, 30));
        toyShop.addToy(new Toy(3, "Конструктор", 7, 20));
        toyShop.addToy(new Toy(4, "Машинка", 8, 0));
    }

    @Test
    public void testAddToy() {
        // Добавляем новую игрушку
        toyShop.addToy(new Toy(5, "Набор кисточек", 3, 0));
        List<Toy> toys = toyShop.getToys();
        // Проверяем, что игрушка добавилась
        assertEquals(5, toys.size());
        // Проверяем, что добавилась нужная игрушка
        Toy newToy = toys.get(4);
        assertEquals(5, newToy.getId());
        assertEquals("Набор кисточек", newToy.getName());
        assertEquals(3, newToy.getQuantity());
        assertEquals(0, newToy.getWeight());
    }


    @Test
    public void testChangeFrequency() {
        // Изменяем вес игрушки с id=1
        toyShop.changeFrequency(1, 70);
        List<Toy> toys = toyShop.getToys();
        // Проверяем, что вес изменился
        Toy toy = toys.get(0);
        assertEquals(70, toy.getFrequency());
    }





}
