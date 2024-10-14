package org.gdzdev.springboot.di.app.services;

import org.gdzdev.springboot.di.app.models.Product;

import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la gestión de productos.
 * <p>
 * Proporciona operaciones de negocio relacionadas con los productos, actuando como intermediario entre el controlador y el repositorio.
 * </p>
 */
public interface ProductService {

        /**
         * Recupera todos los productos disponibles.
         *
         * @return Lista de objetos {@link Product}.
         */
        List<Product> findAllProducts();

        /**
         * Busca un producto específico utilizando su identificador único.
         *
         * @param id Identificador único del producto a buscar.
         * @return Objeto {@link Product} correspondiente al ID proporcionado, o null si no se encuentra.
         */
        Product findProductById(Long id);
}
