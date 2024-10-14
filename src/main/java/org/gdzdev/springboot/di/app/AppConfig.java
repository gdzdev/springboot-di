package org.gdzdev.springboot.di.app;

import org.gdzdev.springboot.di.app.repositories.ProductRepository;
import org.gdzdev.springboot.di.app.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("repoJson")
    public ProductRepository repositoryJson() {
        return new ProductRepositoryJson(this.resource);
    }

}
