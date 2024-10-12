package org.gdzdev.springboot.di.app.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gdzdev.springboot.di.app.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> jsonProducts;

    public ProductRepositoryJson () {
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson (Resource resource) {
        readValueJson(resource);
    }

    @Override
    public List<Product> findAll () {
        return this.jsonProducts;
    }

    @Override
    public Product findById (Long id) {
        return this.jsonProducts.stream().filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonProducts = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
