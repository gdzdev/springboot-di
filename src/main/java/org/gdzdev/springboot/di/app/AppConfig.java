package org.gdzdev.springboot.di.app;

import org.gdzdev.springboot.di.app.repositories.ProductRepository;
import org.gdzdev.springboot.di.app.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * Clase de configuración de Spring que define los beans del contenedor de IoC.
 * <p>
 * Esta clase se utiliza para configurar el acceso a los recursos y crear instancias de los repositorios.
 * </p>
 */
@Configuration
public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    /**
     * Crea un bean del repositorio que carga productos desde un archivo JSON.
     *
     * @return Instancia de {@link ProductRepository} que utiliza datos de un archivo JSON.
     */
    @Bean("repoJson")
    public ProductRepository repositoryJson() {
        return new ProductRepositoryJson(this.resource);
    }

}
