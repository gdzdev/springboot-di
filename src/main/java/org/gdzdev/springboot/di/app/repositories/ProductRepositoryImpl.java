package org.gdzdev.springboot.di.app.repositories;

import java.util.List;
import java.util.Arrays;

import org.gdzdev.springboot.di.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository("repo")
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300),
                new Product(2L, "Procesador Rayzen 7", 100),
                new Product(3L, "CPU Intel core i9", 86));
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
