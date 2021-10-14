package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book bookViy = new Book(1, "Вий", 100, "Гоголь");
    Smartphone smartphoneLG = new Smartphone(2, "LG", 10500, "Корея");
    Book bookWe = new Book(3, "Идиот", 300, "Достоевский");
    Smartphone smartphoneNokia = new Smartphone(4, "Нокиа", 50000, "Финляндия");
    Smartphone smartphoneSamsung = new Smartphone(5, "Нокиа", 45000, "Канада");

    @BeforeEach
    public void setUp() {
        manager.add(bookViy);
        manager.add(smartphoneLG);
        manager.add(bookWe);
        manager.add(smartphoneNokia);
        manager.add(smartphoneSamsung);
    }


    @Test
    void shouldAdd() {
        Product[] expected = new Product[] {bookViy, smartphoneLG, bookWe, smartphoneNokia, smartphoneSamsung};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {

        Product[] expected = new Product[] {bookViy};
        Product[] actual = manager.searchBy("Гоголь");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {

        Product[] expected = new Product[] {bookWe};
        Product[] actual = manager.searchBy("Идиот");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByModel() {

        Product[] expected = new Product[] {smartphoneLG};
        Product[] actual = manager.searchBy("LG");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {

        Product[] expected = new Product[] {smartphoneNokia};
        Product[] actual = manager.searchBy("Финляндия");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNothing() {

        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy(" ");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeProducts() {

        Product[] expected = new Product[] {smartphoneNokia, smartphoneSamsung};
        Product[] actual = manager.searchBy("Нокиа");
        assertArrayEquals(expected, actual);
    }


}