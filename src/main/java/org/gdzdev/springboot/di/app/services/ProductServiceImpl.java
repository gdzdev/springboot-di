package org.gdzdev.springboot.di.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.gdzdev.springboot.di.app.models.Product;
import org.gdzdev.springboot.di.app.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

        @Autowired
        @Qualifier("repoJson") // elegir por el nombre del Bean en el contendor de IoC
        private ProductRepository repository;

        @Override
        public List<Product> findAllProducts() {
                return repository.findAll();
        }

        @Override
        public Product findProductById(Long id) {
                return repository.findById(id);
        }

}
