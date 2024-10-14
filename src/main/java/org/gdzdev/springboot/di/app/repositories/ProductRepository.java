package org.gdzdev.springboot.di.app.repositories;

import java.util.List;

import org.gdzdev.springboot.di.app.models.Product;

/**
 * Interfaz que define los métodos para el acceso a los datos de productos.
 * Proporciona operaciones básicas para interactuar con el almacenamiento de productos.
 */
public interface ProductRepository {

    /**
     * Recupera todos los productos disponibles en el repositorio.
     *
     * @return Lista de objetos {@link Product}.
     */
    List<Product> findAll();

    /**
     * Busca un producto específico utilizando su identificador único.
     *
     * @param id Identificador único del producto a buscar.
     * @return Objeto {@link Product} correspondiente al ID proporcionado.
     */
    Product findById(Long id);

}
