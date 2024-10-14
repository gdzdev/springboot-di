package org.gdzdev.springboot.di.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.gdzdev.springboot.di.app.models.Product;
import org.gdzdev.springboot.di.app.repositories.ProductRepository;

/**
 * Implementación del servicio de productos que maneja la lógica de negocio.
 * <p>
 * Esta clase interactúa con el repositorio para realizar operaciones sobre los productos,
 * utilizando la inyección de dependencias para obtener la implementación del repositorio.
 * </p>
 */
@Service
public class ProductServiceImpl implements ProductService {

        @Autowired
        @Qualifier("repoJson") // Se elige la implementación de ProductRepository por su nombre en el contenedor de IoC
        private ProductRepository repository;

        /**
         * Recupera todos los productos disponibles mediante el repositorio.
         *
         * @return Lista de objetos {@link Product}.
         */
        @Override
        public List<Product> findAllProducts() {
                return repository.findAll();
        }

        /**
         * Busca un producto específico utilizando su identificador único.
         *
         * @param id Identificador único del producto a buscar.
         * @return Objeto {@link Product} correspondiente al ID proporcionado, o null si no se encuentra.
         */
        @Override
        public Product findProductById(Long id) {
                return repository.findById(id);
        }

}
