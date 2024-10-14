package org.gdzdev.springboot.di.app.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gdzdev.springboot.di.app.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Implementación del repositorio de productos que carga los datos desde un archivo JSON.
 * <p>
 * Esta clase utiliza Jackson para deserializar un archivo JSON y proporcionar acceso a los productos.
 * </p>
 */
public class ProductRepositoryJson implements ProductRepository {

    private List<Product> jsonProducts;

    /**
     * Constructor que carga los productos desde un archivo JSON en el classpath.
     */
    public ProductRepositoryJson () {
        // Cargar el recurso
        Resource resource = new ClassPathResource("json/product.json");
        // Este método lee el contenido del JSON
        readValueJson(resource);
    }

    /**
     * Constructor que permite pasar un recurso específico para cargar productos.
     *
     * @param resource Recurso que contiene el archivo JSON de productos.
     */
    public ProductRepositoryJson (Resource resource) {
        readValueJson(resource);
    }

    /**
     * Recupera todos los productos disponibles en el repositorio.
     *
     * @return Lista de objetos {@link Product}.
     */
    @Override
    public List<Product> findAll () {
        return this.jsonProducts;
    }

    /**
     * Busca un producto específico utilizando su identificador único.
     * <p>
     * Este método utiliza un flujo para buscar el producto en la lista cargada desde el JSON.
     * </p>
     *
     * @param id Identificador único del producto a buscar.
     * @return Objeto {@link Product} correspondiente al ID proporcionado, o null si no se encuentra.
     */
    @Override
    public Product findById (Long id) {
        return this.jsonProducts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * Lee los valores del archivo JSON y los deserializa en una lista de productos.
     *
     * @param resource Recurso que contiene el archivo JSON.
     */
    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.jsonProducts = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
