package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product prod1 = new Product(1, "book1");
    Product prod2 = new Product(2, "book2");

    @Test
    public void shouldSearchBy() {


    }

}
