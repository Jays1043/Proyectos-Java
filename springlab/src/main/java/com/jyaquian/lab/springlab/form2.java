package com.jyaquian.lab.springlab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forma2")
public class form2 {
    @GetMapping("/objetoDatos")
    public ObjetoDatos obtenerObjetoDatos() {
        ObjetoDatos objetoDatos = new ObjetoDatos();
        objetoDatos.setNombre("Josue Alejandro Yaquian Sarceño");
        objetoDatos.setCarnet("3190-22-7332");
        objetoDatos.setListado("10");
        return objetoDatos;
    }
}
