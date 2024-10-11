package org.gdzdev.springboot.di.app.services;

import org.gdzdev.springboot.di.app.models.Product;

import java.util.List;

public interface ProductService {

        List<Product> findAllProducts();

        Product findProductById(Long id);
}
