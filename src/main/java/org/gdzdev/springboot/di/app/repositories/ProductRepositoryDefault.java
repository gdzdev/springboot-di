package org.gdzdev.springboot.di.app.repositories;

import java.util.Collections;
import java.util.List;

import org.gdzdev.springboot.di.app.models.Product;
import org.springframework.stereotype.Repository;

/**
 * Implementación del repositorio de productos que proporciona datos de productos predeterminados.
 * <p>
 * Esta clase implementa la interfaz {@link ProductRepository} y simula el acceso a un almacenamiento de datos.
 * </p>
 */
@Repository("defaultRepo")
public class ProductRepositoryDefault implements ProductRepository {

    /**
     * Recupera todos los productos disponibles.
     * <p>
     * En esta implementación, se devuelve una lista con un único producto simulado.
     * </p>
     *
     * @return Lista de objetos {@link Product}.
     */
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Laptop ASUS", 499));
    }

    /**
     * Busca un producto específico por su ID.
     * <p>
     * En esta implementación, se devuelve un producto simulado con el ID proporcionado.
     * </p>
     *
     * @param id Identificador único del producto a buscar.
     * @return Objeto {@link Product} correspondiente al ID proporcionado.
     */
    @Override
    public Product findById(Long id) {
        return new Product(id, "Laptop ASUS", 499);
    }

}
