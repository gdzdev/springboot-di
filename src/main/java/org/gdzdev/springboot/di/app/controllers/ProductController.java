package org.gdzdev.springboot.di.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.gdzdev.springboot.di.app.models.Product;
import org.gdzdev.springboot.di.app.services.*;

/**
 * Controlador que maneja las operaciones relacionadas con productos.
 * <p>
 * Este controlador expone endpoints para obtener todos los productos y para obtener un producto específico por su ID.
 * </p>
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    /**
     * Servicio que maneja la lógica de negocio relacionada con productos.
     * <p>
     * Utiliza inyección de dependencias para obtener una instancia de {@link ProductService}.
     * </p>
     */
    @Autowired
    private ProductService service;

    /**
     * Obtiene la lista de todos los productos disponibles.
     *
     * @return Lista de objetos {@link Product}.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAllProducts();
    }

    /**
     * Obtiene los detalles de un producto específico por su ID.
     *
     * @param id Identificador único del producto.
     * @return Objeto {@link Product} correspondiente al ID proporcionado.
     */
    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.findProductById(id);
    }

}
