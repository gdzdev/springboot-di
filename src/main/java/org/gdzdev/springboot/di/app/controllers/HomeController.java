package org.gdzdev.springboot.di.app.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /**
     * Maneja las solicitudes HTTP GET a las rutas "", "/", y "home".
     * @return Mapa que contiene un mensaje de bienvenida.
     */
    @GetMapping({ "", "/", "home" })
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the API home");
        return response;
    }

}
