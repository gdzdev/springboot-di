package org.gdzdev.springboot.di.app.repositories;

import java.util.List;
import java.util.Arrays;

import org.gdzdev.springboot.di.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Implementación del repositorio de productos que gestiona un conjunto de productos en memoria.
 * <p>
 * Esta clase proporciona métodos para acceder a los productos, simula un repositorio persistente utilizando datos en memoria.
 * </p>
 */
@Primary
@Repository("repo")
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> data;

    /**
     * Constructor que inicializa la lista de productos con datos predeterminados.
     */
    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300),
                new Product(2L, "Procesador Rayzen 7", 100),
                new Product(3L, "CPU Intel core i9", 86));
    }

    /**
     * Recupera todos los productos disponibles en el repositorio.
     *
     * @return Lista de objetos {@link Product}.
     */
    @Override
    public List<Product> findAll() {
        return this.data;
    }

    /**
     * Busca un producto específico utilizando su identificador único.
     * <p>
     * Este método utiliza un flujo para buscar el producto en la lista de datos.
     * </p>
     *
     * @param id Identificador único del producto a buscar.
     * @return Objeto {@link Product} correspondiente al ID proporcionado, o null si no se encuentra.
     */
    @Override
    public Product findById(Long id) {
        return this.data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);
    }

}
