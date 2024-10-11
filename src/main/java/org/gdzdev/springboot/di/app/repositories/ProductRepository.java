package org.gdzdev.springboot.di.app.repositories;

import java.util.List;

import org.gdzdev.springboot.di.app.models.Product;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}
