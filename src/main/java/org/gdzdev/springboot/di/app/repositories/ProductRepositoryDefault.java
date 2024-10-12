package org.gdzdev.springboot.di.app.repositories;

import java.util.Collections;
import java.util.List;

import org.gdzdev.springboot.di.app.models.Product;
import org.springframework.stereotype.Repository;

@Repository("defaultRepo")
public class ProductRepositoryDefault implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Laptop ASUS", 499));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Laptop ASUS", 499);
    }

}
